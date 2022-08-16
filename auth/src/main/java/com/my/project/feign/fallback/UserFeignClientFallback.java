package com.my.project.feign.fallback;

import com.my.project.common.dto.ResultDTO;
import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.feign.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * user interface Fallback
 *
 * @author
 */
@Component
public class UserFeignClientFallback implements UserFeignClient {

    @Override
    public ResultDTO<UserLoginInfo> getById(Long id) {
        return new ResultDTO<>();
    }

    @Override
    public ResultDTO<UserLoginInfo> getByUsername(String username) {
        return new ResultDTO<>();
    }

    @Override
    public ResultDTO<UserLoginInfo> getUserBySso(String username) {
        return new ResultDTO<>();
    }
}
