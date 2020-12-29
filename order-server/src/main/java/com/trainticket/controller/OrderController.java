package com.trainticket.controller;

import com.trainticket.constant.CommonConst;
import com.trainticket.entity.CustomUser;
import com.trainticket.entity.Order;
import com.trainticket.entity.TtResponse;
import com.trainticket.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

/**
 * @Author user
 * @Date 2020/12/29 4:29 PM
 * @Version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private OrderService orderService;

    @PostMapping("/upload")
    public TtResponse<String> uploadOrder(@RequestBody Order order, @CookieValue("TT_token") String token){
        try {
            CustomUser user = (CustomUser) valueOperations.get(token);
            order.setCustomer_id(user.getId());
            return orderService.saveOrder(order);
        }catch (Exception e){
            log.error("## 保持订单出错：{}", ExceptionUtils.getStackTrace(e));
            return new TtResponse<>(500, CommonConst.CODE_500_MSG, "");
        }
    }
}
