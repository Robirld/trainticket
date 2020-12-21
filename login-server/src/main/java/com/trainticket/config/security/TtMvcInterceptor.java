package com.trainticket.config.security;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.trainticket.constant.CommonConst;
import com.trainticket.entity.TtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author user
 * @Date 2020/12/18 5:52 PM
 * @Version 1.0
 */
@Component
public class TtMvcInterceptor implements HandlerInterceptor {
    @Autowired
    private ValueOperations<String,Object> valueOperations;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        Object o = null;
        for (Cookie cookie:cookies){
            if (CommonConst.TT_TOKEN_KEY.equalsIgnoreCase(cookie.getName())){
                o = valueOperations.get(cookie.getValue());
                break;
            }
        }

        if (o == null){
            TtResponse<Object> res = new TtResponse<>(401, "请先登录", null);
            JsonMapper jsonMapper = new JsonMapper();
            String string = jsonMapper.writeValueAsString(res);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            return false;
        }
        return true;
    }
}
