package com.my.project.service;

import com.my.project.common.dto.ResultDTO;
import com.my.project.dto.AuthorizationDTO;
import com.my.project.dto.LoginDTO;


/**
 * AuthService
 *
 * @author
 */
public interface AuthService {


    /**
     * login
     */
    ResultDTO<AuthorizationDTO> login(LoginDTO login);

    /**
     * logout
     */
    void logout(Long userId);

}
