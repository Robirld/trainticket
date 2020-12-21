package com.trainticket.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author user
 * @Date 2020/12/15 4:59 PM
 * @Version 1.0
 */
@Configuration
public class TtWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private TtMvcInterceptor mvcInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true).allowedHeaders("*");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mvcInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/signup","/logout");
    }
}
