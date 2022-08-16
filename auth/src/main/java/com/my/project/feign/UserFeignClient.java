package com.my.project.feign;

import com.my.project.common.dto.ResultDTO;
import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.feign.fallback.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

/**
 * user interface
 *
 * @author
 */
@FeignClient(value="core-server", fallback = UserFeignClientFallback.class)
@ApiIgnore
public interface UserFeignClient {

    /**
     * According to the user ID, get the user information.
     */
    @GetMapping("sys/sysuser/getById")
    ResultDTO<UserLoginInfo> getById(@RequestParam("id") Long id);

    /**
     * According to the user name, get the user information.
     * @param username  user name
     */
    @GetMapping("sys/sysuser/getByUsername")
    ResultDTO<UserLoginInfo> getByUsername(@RequestParam("username") String username);

    /**
     * According to sso user name, get the user information.
     * @param username  user name
     */
    @GetMapping("sys/sysuser/getUserBySso")
    ResultDTO<UserLoginInfo> getUserBySso(@RequestParam("username") String username);

}
