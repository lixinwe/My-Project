package com.my.project.common.user;

import lombok.Data;

import java.io.Serializable;

/**
 * Resource
 *
 * @author
 */
@Data
public class ResourceBO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Resource Url
     */
    private String resourceUrl;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(String resourceMethod) {
        this.resourceMethod = resourceMethod;
    }

    public Long getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(Long authLevel) {
        this.authLevel = authLevel;
    }

    /**
     * resource Method（e.g.：GET、POST、PUT、DELETE）
     */
    private String resourceMethod;
    /**
     * auth level   0：role   1：login    2：not auth
     */
    private Long authLevel;

}
