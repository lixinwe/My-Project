package com.my.project.common.redis;

/**
 * @author
 */
public class RedisKeys {
    /**
     *  sys param Key
     */
    public static String getSysParamsKey(){
        return "sys:params";
    }

    public static String getSysWorkflowProcKey(){
        return "sys:workflow:proc";
    }

    /**
     * system captcha Key
     */
    public static String getLoginCaptchaKey(String uuid){
        return "sys:captcha:" + uuid;
    }

    /**
     * system login Key
     */
    public static String getSecurityUserKey(Long id){
        return "sys:security:user:" + id;
    }

    /**
     * system log Key
     */
    public static String getSysLogKey(){
        return "sys:log";
    }

    /**
     * System resource key
     */
    public static String getSysResourceKey(){
        return  "sys:resource";
    }

    /**
     * User menu navigation key
     */
    public static String getUserMenuNavKey(Long userId, String language){
        return "sys:user:nav:" + userId + "_" + language;
    }

    /**
     * User menu navigation key
     */
    public static String getUserMenuNavKey(Long userId){
        return "sys:user:nav:" + userId + "_*";
    }


    /**
     * Business log key
     */
    public static String getLogKey(){
        return "bmw:project:bznslog";
    }
    /**
     * User authority ID key
     */
    public static String getUserPermissionsKey(Long userId){
        return "bmw:project:user:permissions:" + userId;
    }

    /**
     * Non admin user resource list key
     * @param userId
     * @return
     */
    public static String getUserResourceKey(Long userId) {
        return "bmw:project:user:resource:" + userId;
    }

    /**
     * User role key
     */
    public static String getUserRoleKey(Long userId){
        return "bmw:project:user:role:" + userId;
    }

    /**
     * User role data permission key
     */
    public static String getUserRoleDataScopeKey(Long userId){
        return "bmw:project:user:role:datascope" + userId;
    }
    /**
     * user_code Key
     */
    public static String getLoggingUserCodeKey(String userCode){
        return "project:logging:user:" + userCode;
    }

    /**
     * SapMaterialMasterMaktKey
     */
    public static String getSapMaterialMasterMaktKey(){
        return "sap:material:master:maktkey";
    }

    /**
     * SapQmnDictKey
     */
    public static String getSapQmnDictKey(){
        return "sap:qmn:dict";
    }

    /**
     * SapLydiaMaterialMasterMaktKey
     */
    public static String getSapLydiaMaterialMasterMaktKey(){
        return "saplydia:material:master:maktkey";
    }

    /**
     * SapLydiaQmnDictKey
     */
    public static String getSapLydiaQmnDictKey(){
        return "saplydia:qmn:dict";
    }

    /**
     * SapQmnBomKey
     */
    public static String getSapQmnBomKey(){
        return "sap:qmn:bom";
    }

    /**
     * QCIP System user and the field display authority key of a table
     */
    public static String getQcipUserTableKey(Long userId){
        return "qcip:user:table:" + userId;
    }

    /**
     * SapQmtPartsKey
     */
    public static String getSapQmtPartsKey(){
        return "sap:qmn:qmtparts";
    }

    /**
     * QmnMaterialMasterMaktKey
     */
    public static String getQmnMaterialMasterMaktKey(){
        return "qmn:material:master:maktkey";
    }

    /**
     * SapLydiaQmtPartsKey
     */
    public static String getSapLydiaQmtPartsKey(){
        return "saplydia:qmn:qmtparts";
    }

    /**
     * LydiaQmnMaterialMasterMaktKey
     */
    public static String getLydiaQmnMaterialMasterMaktKey(){
        return "qmnlydia:material:master:maktkey";
    }
}
