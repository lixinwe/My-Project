package com.my.project.controller;

import com.my.project.common.dto.ResultDTO;
import com.my.project.common.validator.ValidatorUtils;
import com.my.project.dto.*;
import com.my.project.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Authorization management
 *
 * @author
 */
@RestController
@Api(tags="Authorization management")
public class AuthController {
    @Autowired
    private AuthService authService;


    @PostMapping(value = "login")
    @ApiOperation(value = "login")
    public ResultDTO<AuthorizationDTO> login(@RequestBody LoginDTO login){
        ResultDTO<AuthorizationDTO> resultDto = new ResultDTO<>();
        if(!StringUtils.isEmpty(login.getUsername())){
            login.setUsername(login.getUsername().toUpperCase());
        }
        ValidatorUtils.validateEntity(login);
        resultDto = authService.login(login);
        return resultDto;
    }

    @PostMapping(value = "logout")
    @ApiOperation(value = "logout")
    public ResultDTO logout(HttpServletRequest request){
        String userId = request.getHeader("userId");

        authService.logout(Long.parseLong(userId));

        return new ResultDTO();
    }

}
