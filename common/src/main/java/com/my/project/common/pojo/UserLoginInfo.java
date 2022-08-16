package com.my.project.common.pojo;

import com.my.project.common.user.ResourceBO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Tim
 * @create 2019-07-16 18:44
 */
@Data
public class UserLoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * user key field userid
     */
    private Long userId;

    /**
     * data sort
     */
    private Long dataSort;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * user account
     */
    private String userCode;

    /**
     * password
     */
    private String password;

    /**
     * chinese name
     */
    private String realName;

    /**
     * mobile
     */
    private String mobile;

    /**
     * Name of updater in Chinese
     */
    private String updateUserNameCn;

    /**
     * Name of updater in english
     */
    private String createUserNameEn;

    /**
     * Updater user number external system
     */
    private String updateUserCode;

    /**
     * Permission classification: 10 admin 20 ordinary users 30 teachers 40 management level ordinary users need approval and role linkage
     */
    private String authType;

    /**
     * create User
     */
    private Long createUser;

    /**
     * english name
     */
    private String enName;

    /**
     * data status
     */
    private Long dataStatus;

    /**
     * create user number external system
     */
    private String createUserCode;

    /**
     * gender   0：man   1：female    2：secrecy
     */
    private Long gender;

    /**
     * plant
     */
    private String plant;

    /**
     * create User Name chinese
     */
    private String createUserNameCn;

    /**
     * update User
     */
    private Long updateUser;

    /**
     * update User NameEn
     */
    private String updateUserNameEn;

    /**
     * create Time
     */
    private Date createTime;

    /**
     * Division of functions of employed departments
     */
    private String userType;

    /**
     * delete flag
     */
    private Long delFlag;

    /**
     * department
     */
    private String deptId;

    /**
     * headUrl
     */
    private String headUrl;

    /**
     * email
     */
    private String email;

    /**
     * area
     */
    private String processArea;

    /**
     * Authority: 0 super administrator 1 TA administrator 2 ordinary administrator 3 others
     */
    private String roleTypeVal;

    /**
     * server address
     */
    private String uploadHost;

    /**
     * Emergency contact person and contact information
     */
    private String emergencyContactInfo;

    /**
     * Privacy agreement file address
     */
    private String privacyFileUrl;

    /**
     * user login IP
     */
    private String userLoginIp;

    /**
     * User login browser
     */
    private String  userAgent;

    /**
     *
     */
    private Integer superAdmin;

    /**
     * Default cost center
     */
    private String costCenter;

    /**
     * Whether to be offline by administrator 0: normal 1: offline, no right to call interface
     */
    private int kill;

    /**
     * firstName
     */
	private String firstName;


    /**
     * last Name
     */
	private String lastName;

    /**
     * account type
     */
	private String emptype;

    /**
     * empno
     */
	private String empno;

    /**
     * display Name
     */
	private String displayName;

    /**
     * plant Name
     */
	private String plantName;

    /**
     * company name
     */
	private String company;

    /**
     * department name
     */
	private String depShortName;

    /**
     * telphone
     */
	private String telphone;

    /**
     * department list
     */
    private List<Long> deptIdList;
    /**
     * user resource list
     */
    private List<ResourceBO> resourceList;
    /**
     * subsystem list
     */
    private List<String> subSystemList;
    /**
     * plant list
     */
    private List<String> plantList;
    /**
     * cost center list
     */
    private List<String> costCenterList;

    /**
     * token
     */
    private String token;
}
