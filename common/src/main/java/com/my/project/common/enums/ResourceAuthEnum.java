package com.my.project.common.enums;

/**
 * Resource Auth Enum
 *
 * @author
 */
public enum ResourceAuthEnum {
    /**
     * role auth
     */
    PERMISSIONS_AUTH(0L),
    /**
     * login auth
     */
    LOGIN_AUTH(1L),
    /**
     * not auth
     */
    NO_AUTH(2L);


    private Long value;

    ResourceAuthEnum(Long value) {
        this.value = value;
    }

    public Long value() {
        return this.value;
    }
}
