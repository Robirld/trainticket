package com.trainticket.controller;

import com.trainticket.entity.Passenger;
import com.trainticket.entity.TtResponse;
import com.trainticket.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/24 6:12 PM
 * @Version 1.0
 */
@RestController
@RequestMapping("/passenger")
@Slf4j
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/list")
    public TtResponse<List<Passenger>> getPassengers(@CookieValue("TT_token") String token){
        try {
            return new TtResponse<>(200, "success", passengerService.findByCustomerId(token));
        }catch (Exception e){
            log.error("## 获取乘客信息失败：token-{},error-{}", token, e);
            return new TtResponse<>(500, "服务器错误，请稍后重试！", null);
        }
    }
}
