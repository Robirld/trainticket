package com.trainticket.handler;

import com.trainticket.config.security.TtPasswordEncoder;
import com.trainticket.entity.CustomUser;
import com.trainticket.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author user
 * @Date 2020/12/15 3:09 PM
 * @Version 1.0
 */
@Component
public class LoginHandler implements TtHandler<CustomUser, String> {
    @Autowired
    private CustomUserService customUserService;

    @Autowired
    private TtPasswordEncoder passwordEncoder;

    @Autowired
    private ValueOperations<String, Object> valueOperations;

    @Override
    public String execute(CustomUser user) throws Exception {
        CustomUser customUser = customUserService.loadUserByUsername(user.getUsername());
        if (customUser == null){
            throw new Exception("用户不存在");
        }
        boolean matches = passwordEncoder.matches(user.getPassword(), customUser.getPassword());
        if (!matches){
            throw new Exception("密码错误");
        }

        String loginToken = UUID.randomUUID().toString();

        valueOperations.set(loginToken, customUser, 1, TimeUnit.DAYS);

        return loginToken;
    }
}
