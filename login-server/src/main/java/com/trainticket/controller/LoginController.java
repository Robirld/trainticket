package com.trainticket.controller;

import com.trainticket.entity.CustomUser;
import com.trainticket.entity.TtResponse;
import com.trainticket.handler.LoginHandler;
import com.trainticket.handler.LogoutHandler;
import com.trainticket.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author user
 * @Date 2020/12/15 4:15 PM
 * @Version 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private LoginHandler loginHandler;

    @Autowired
    private LogoutHandler logoutHandler;

    @Autowired
    CustomUserService userService;

    @PostMapping("/login")
    public TtResponse<Map<String, String>> login(@RequestBody CustomUser user){
        try {
            String token = loginHandler.execute(user);
            return new TtResponse<>(200, token, null);
        } catch (Exception e) {
            return new TtResponse<>(401, e.getMessage(), null);
        }
    }

    @PostMapping("/signup")
    public TtResponse<Map<String, String>> signUp(@RequestBody CustomUser user){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            return new TtResponse<>(417, "用户名和密码不能为空", null);
        }
        try {
            userService.save(user);
            return new TtResponse<>(200, "success", null);
        }catch (Exception e){
            return new TtResponse<>(500, "注册失败", null);
        }
    }

    @PostMapping("/logout")
    public TtResponse<Object> logout(@CookieValue("TT_token") String token){
        if (StringUtils.isEmpty(token)){
            return new TtResponse<>(200, "", null);
        }
        try {
            logoutHandler.execute(token);
            return new TtResponse<>(200, "", null);
        } catch (Exception e) {
            return new TtResponse<>(500, "注销失败", null);
        }
    }
}
