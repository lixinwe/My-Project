package com.my.project.common.redis;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.my.project.common.pojo.UserLoginInfo;
import com.my.project.common.security.user.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * user Redis
 *
 * @author
 */
@Component(value = "myUserDetailRedis")
public class UserDetailRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void set(UserLoginInfo user, long expire){
        if(user == null){
            return ;
        }
        Long userId = Long.valueOf(user.getUserId());
        String key = RedisKeys.getSecurityUserKey(userId);
        // bean to map
        user.setKill(0);
        Map<String, Object> map = BeanUtil.beanToMap(user, false, true);
        redisUtils.hmSet(key, map, expire);

        // When the user logs in, clear the menu navigation and authority identification
        redisUtils.delete(RedisKeys.getUserMenuNavKey(userId));
        redisUtils.delete(RedisKeys.getUserPermissionsKey(userId));
    }

    public UserDetail get(Long id){
        String key = RedisKeys.getSecurityUserKey(id);

        Map<String, Object> map = redisUtils.hGetAll(key);
        if(MapUtil.isEmpty(map)){
            return null;
        }

        //map to bean
        UserDetail user = BeanUtil.mapToBean(map, UserDetail.class, true);

        return user;
    }

    /**
     * user logout
     * @param id  user ID
     */
    public void logout(Long id){
        String key = RedisKeys.getSecurityUserKey(id);
        // redisUtils.hSet(key, "kill", UserKillEnum.YES.value());
        redisUtils.delete(key);
        // clear the menu navigation and authority identification
        redisUtils.deleteByPattern(RedisKeys.getUserMenuNavKey(id));
        redisUtils.delete(RedisKeys.getUserPermissionsKey(id));
    }
}
