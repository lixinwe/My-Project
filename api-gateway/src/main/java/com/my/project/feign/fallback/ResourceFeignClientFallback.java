package com.my.project.feign.fallback;

import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.common.utils.Result;
import com.my.project.feign.ResourceFeignClient;
import org.springframework.stereotype.Component;

/**
 * Resource interface Fallback
 *
 * @author
 */
@Component
public class ResourceFeignClientFallback implements ResourceFeignClient {

    @Override
    public Result<UserLoginInfo> resource(String language, String token, String url, String method, String requesthost) {
        return new Result<UserLoginInfo>().error();
    }
}
