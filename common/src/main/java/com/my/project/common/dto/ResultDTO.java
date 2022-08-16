package com.my.project.common.dto;

import com.my.project.common.exception.ErrorCode;
import com.my.project.common.utils.MessageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * response data
 *
 * @author
 */
@Data
@ApiModel(value = "response data")
public class ResultDTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * response code：0 is success，other is error
     */
    @ApiModelProperty(value = "response code：0 is success，other is error")
    private Integer code;
    /**
     * response message
     */
    @ApiModelProperty(value = "response message")
    private String msg;
    /**
     * response data
     */
    @ApiModelProperty(value = "response data")
    private T data;

    public ResultDTO<T> setResult(T data) {
        this.setData(data);
        return this;
    }

    public boolean success() {
        return code == 0 ? true : false;
    }

    public ResultDTO<T> error() {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = MessageUtils.getMessage(this.code);
        return this;
    }

    public ResultDTO<T> error(Integer code) {
        this.code = code;
        this.msg = MessageUtils.getMessage(this.code);
        return this;
    }

    public ResultDTO<T> error(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public ResultDTO<T> error(String msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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


    public ResultDTO() {
        code = 0;
        msg = "Success";
    }

}
