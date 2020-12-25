package com.trainticket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * @Author user
 * @Date 2020/12/16 8:10 PM
 * @Version 1.0
 */
@Component
public class LogoutHandler implements TtHandler<String, String> {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public String execute(String s) throws Exception {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        Object user = valueOperations.get(s);
        if (user == null){
            return "success";
        }
        redisTemplate.delete(s);
        return "success";
    }
}
