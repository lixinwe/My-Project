package com.my.project.common.redis;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.my.project.common.pojo.UserLoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Read or save login user information in redis
 *
 * @author Tim
 */
@Component
public class UserLoginInfoRedis {

    private RedisUtils redisUtils;

    @Autowired
    public UserLoginInfoRedis(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    public void set(UserLoginInfo user, long expire){
        if(null == user){
            return ;
        }
        String key = RedisKeys.getSecurityUserKey(user.getUserId());
        //bean to map
        user.setKill(0);
        Map<String, Object> map = BeanUtil.beanToMap(user, false, true);
        redisUtils.hmSet(key, map, expire);

        redisUtils.delete(RedisKeys.getUserMenuNavKey(user.getUserId()));
        redisUtils.delete(RedisKeys.getUserPermissionsKey(user.getUserId()));
    }

    public UserLoginInfo get(Long id){
        String key = RedisKeys.getSecurityUserKey(id);
        //System.out.println(key);
        Map<String, Object> map = redisUtils.hGetAll(key);
        //System.out.println(map);
        if(MapUtil.isEmpty(map)){
            return null;
        }
        //map to bean
        UserLoginInfo user = BeanUtil.mapToBean(map, UserLoginInfo.class, true);
        //System.out.println(user.toString());
        return user;
    }

    /**
     * logout
     * @param id  id
     */
    public void logout(Long id){
        String key = RedisKeys.getSecurityUserKey(id);
        redisUtils.hSet(key, "kill", 1);

        redisUtils.deleteByPattern(RedisKeys.getUserMenuNavKey(id));
        redisUtils.delete(RedisKeys.getUserPermissionsKey(id));
    }
}
