package com.my.project.common.security.bo;

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
     * Resource url
     */
    private String resourceUrl;
    /**
     * resource Method（e.g.：GET、POST、PUT、DELETE）
     */
    private String resourceMethod;
    /**
     * auth level   0：role   1：login    2：not auth
     */
    private Integer authLevel;

}
