package com.my.project.config;

import com.my.project.common.utils.FeignBasicAuthRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignSupportConfig {
    /**
     * feign request interceptor
     *
     * @return
     */
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignBasicAuthRequestInterceptor();
    }
}
