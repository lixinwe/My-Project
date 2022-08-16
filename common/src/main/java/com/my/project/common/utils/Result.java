package com.my.project.common.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * response
 *
 * @author
 */
@ApiModel(value = "response")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Code: 0 means success, other values indicate failure
     */
    @ApiModelProperty(value = "Code: 0 means success, other values indicate failure")
    private int code = 0;
    /**
     * Message content
     */
    @ApiModelProperty(value = "Message content")
    private String msg = "Success";
    /**
     * Response data
     */
    @ApiModelProperty(value = "Response data")
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success(){
        return code == 0 ? true : false;
    }

    public Result<T> error() {
        this.code = 500;
        this.msg = MessageUtils.getMessage(this.code);
        return this;
    }

    public Result<T> error(int code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(this.code);
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
