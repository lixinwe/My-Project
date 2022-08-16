package com.my.project.common.exception;

/**
 * error code
 * <p>
 * 100001（100 is core services，001 is business code）
 * </p>
 * <p>
 *  110 gateway
 *  120 auth
 *  130 core
 * </p>
 * @author
 */
public interface ErrorCode {
    int INTERNAL_SERVER_ERROR = 500;
    int UNAUTHORIZED = 401;
    int FORBIDDEN = 403;

    int NOT_NULL = 120001;
    int ACCOUNT_NOT_EXIST = 120010;
}
