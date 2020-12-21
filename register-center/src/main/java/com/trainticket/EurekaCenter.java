package com.trainticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author user
 * @Date 2020/12/14 2:26 PM
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaCenter {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCenter.class, args);
    }
}
