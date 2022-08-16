package com.my.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Authorization information
 *
 * @author
 */
@Data
@ApiModel(value = "Authorization information")
public class AuthorizationDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "token", required = true)
    private String token;
    @ApiModelProperty(value = "Expiration time in seconds", required = true)
    private Integer expire;

    @ApiModelProperty(value = "Number of subsystems")
    private Integer subSystemNum;

    @ApiModelProperty(value = "Subsystem list")
    private List<String> subSystemList;

    @ApiModelProperty(value = "Super administrator")
    private Integer superAdmin;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}
