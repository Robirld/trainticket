package com.trainticket;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author user
 * @Date 2020/12/18 6:53 PM
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.trainticket.dao"})
public class TicketApp {
    public static void main(String[] args) {
        SpringApplication.run(TicketApp.class,args);
    }
}
