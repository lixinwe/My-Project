package com.my.project.feign;

import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.common.utils.Result;
import com.my.project.feign.fallback.ResourceFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Resource interface
 *
 * @author
 */
@FeignClient(value = "auth-server", fallback = ResourceFeignClientFallback.class)
@ApiIgnore
public interface ResourceFeignClient {
    /**
     * resource
     * @param token    token
     * @param url     url
     * @param method  method
     *
     * @return
     */
    @PostMapping("auth/resource")
    Result<UserLoginInfo> resource(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language, @RequestParam("token") String token,
                                   @RequestParam("url") String url, @RequestParam("method") String method, @RequestParam("requesthost") String requesthost);

}
