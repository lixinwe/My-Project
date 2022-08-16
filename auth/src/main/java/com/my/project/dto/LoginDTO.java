package com.my.project.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * login info
 *
 * @author
 */
@Data
@ApiModel(value = "login info")
public class LoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "user nsmr", required = true)
    @NotBlank(message="{sysuser.username.require}")
    private String username;

    @ApiModelProperty(value = "password")
    @NotBlank(message="{sysuser.password.require}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @ApiModelProperty(value = "captcha")
    // @NotBlank(message="{sysuser.captcha.require}")
    private String captcha;

    @ApiModelProperty(value = "Unique identification")
    @NotBlank(message="{sysuser.uuid.require}")
    private String uuid;

}
