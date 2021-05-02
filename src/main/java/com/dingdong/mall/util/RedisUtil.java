package com.dingdong.mall.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写入String缓存
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public boolean set(final String key,Object value){
        boolean result = false;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 设置缓存过期时间
     * @param key 键
     * @param value 值
     * @param expireTime 过期时间
     * @param timeUnit timeUnit
     * @return boolean
     */
    public boolean set(final String key, Object value, Long expireTime, TimeUnit timeUnit){
        boolean result = false;
        try {
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            redisTemplate.expire(key,expireTime,timeUnit);
            result = true;
        } catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 判断缓存是否存在
     * @param key 键
     * @return boolean
     */
    public boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     * 删除缓存
     * @param key 键
     */
    public void remove(final String key){
        if (exists(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 取出缓存
     * @param key 键
     * @return 缓存
     */
    public Object get(final String key){
        Object result = null;
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);

        return result;
    }



}
