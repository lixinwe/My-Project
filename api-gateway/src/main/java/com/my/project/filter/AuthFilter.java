package com.my.project.filter;

import com.alibaba.fastjson.JSON;
import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.common.utils.Result;
import com.my.project.feign.ResourceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Permission filter.
 *
 * @author
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "myproject")
public class AuthFilter implements GlobalFilter {
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private ResourceFeignClient resourceFeignClient;

    @Autowired
    public AuthFilter(ResourceFeignClient resourceFeignClient) {
        this.resourceFeignClient = resourceFeignClient;
    }

    /**
     * URL whitelist
     */
    private List<String> urls;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String requestUri = request.getPath().pathWithinApplication().value();
        if(pathMatcher(requestUri)){
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst("token");
        if(StringUtils.isEmpty(token)){
            token = request.getQueryParams().getFirst("token");
        }

        //resource access control.
        String language = request.getHeaders().getFirst(HttpHeaders.ACCEPT_LANGUAGE);
        String requestHost = request.getHeaders().getFirst(HttpHeaders.HOST);
        if("localhost:8080".equals(requestHost)){

        } else {
            List<HttpCookie> httpCookie = request.getCookies().get("frontUrl");
            if(httpCookie != null){
                requestHost = httpCookie.get(0).getValue();
            } else {
                requestHost = "";
            }
        }

        Result<UserLoginInfo> result = resourceFeignClient.resource(language, token, requestUri, request.getMethod().toString(),requestHost);
        //No permission to access, return directly.
        if(!result.success()){
            return response(exchange, result);
        }

        //get user info
        UserLoginInfo userDetail = result.getData();
        if(userDetail != null){
            //The currently logged in user userid is added to the header
            ServerHttpRequest build = exchange.getRequest().mutate().header("userId", userDetail.getUserId()+"").build();
            return chain.filter(exchange.mutate().request(build).build());
        }
        //Append username information to headers (build required)
        ServerHttpRequest host = exchange.getRequest().mutate().build();
        //eg:Verification successful, forward request.
        ServerWebExchange build = exchange.mutate().request(host).build();
        return chain.filter(exchange);
    }

    private Mono<Void> response(ServerWebExchange exchange, Object object) {
        String json = JSON.toJSONString(object);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(json.getBytes(StandardCharsets.UTF_8));
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        return exchange.getResponse().writeWith(Flux.just(buffer));
    }

    private boolean pathMatcher(String requestUri){
        for (String url : urls) {
            if(antPathMatcher.match(url, requestUri)){
                return true;
            }
        }
        return false;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
