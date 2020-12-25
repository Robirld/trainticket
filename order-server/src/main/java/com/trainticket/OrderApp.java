package com.trainticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author user
 * @Date 2020/12/25 1:49 PM
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.trainticket.feign"})
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
