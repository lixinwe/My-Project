package com.my.project.common.security.user;

import com.my.project.common.utils.HttpContextUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * user
 *
 * @author
 */
public class SecurityUser {

    /**
     * get user info
     */
    public static UserDetail getUser(){
        Long userId = getUserId();
        if(userId == null){
            return null;
        }
        UserDetail user = null;

        return user;
    }

    /**
     * get user id
     */
    public static Long getUserId() {
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        if(request == null){
            return null;
        }

        String userId = request.getHeader("userId");
        if(StringUtils.isBlank(userId)){
            return null;
        }
        return Long.parseLong(userId);
    }

}
