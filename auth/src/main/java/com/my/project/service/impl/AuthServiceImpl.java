package com.my.project.service.impl;

import com.my.project.common.dto.ResultDTO;
import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.common.redis.UserDetailRedis;
import com.my.project.common.security.password.PasswordUtils;
import com.my.project.dto.AuthorizationDTO;
import com.my.project.dto.LoginDTO;
import com.my.project.feign.UserFeignClient;
import com.my.project.jwt.JwtUtils;
import com.my.project.service.AuthService;
import com.my.project.common.utils.HttpContextUtils;
import com.my.project.jwt.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * AuthServiceImpl
 *
 * @author
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private UserDetailRedis userDetailRedis;


    @Override
    public ResultDTO<AuthorizationDTO> login(LoginDTO login) {
        ResultDTO resultDto = new ResultDTO();
        String defaultSystem = "System";
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        ResultDTO<UserLoginInfo> result = userFeignClient.getByUsername(login.getUsername());
        UserLoginInfo user = result.getData();
        String loginResult,loginErrMsg;
        if(user == null){
            resultDto.error(-1205);
        } else {
            if(!PasswordUtils.matches(login.getPassword(), user.getPassword())){
                resultDto.error(-1006);
            }
            if (resultDto.getCode() == 0) {
                String token = jwtUtils.generateToken(user.getUserId());
                user.setToken(token);
                userDetailRedis.set(user, jwtProperties.getExpire());
                AuthorizationDTO authorization = new AuthorizationDTO();
                authorization.setToken(token);
                authorization.setExpire(jwtProperties.getExpire());
                List<String> subSystem;
                if(user.getSubSystemList() == null || user.getSubSystemList().size() == 0){
                    subSystem = new ArrayList<>();
                    subSystem.add(defaultSystem);
                } else {
                    subSystem = user.getSubSystemList();
                }
                resultDto.setData(authorization);
            }
        }

        return resultDto;
    }

    @Override
    public void logout(Long userId) {

        userDetailRedis.logout(userId);
    }


}
