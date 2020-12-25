package com.trainticket.service;

import com.trainticket.config.security.TtPasswordEncoder;
import com.trainticket.dao.login.CustomUserDao;
import com.trainticket.entity.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author user
 * @Date 2020/12/15 11:54 AM
 * @Version 1.0
 */
@Service
public class CustomUserService {
    @Autowired
    private CustomUserDao customUserDao;

    @Autowired
    TtPasswordEncoder passwordEncoder;

    public CustomUser loadUserByUsername(String s) {
        return customUserDao.findCustomByUsername(s);
    }

    public int save(CustomUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return customUserDao.save(user);
    }
}
