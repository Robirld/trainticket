package com.trainticket.controller.orderserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainticket.constant.CommonConst;
import com.trainticket.constant.MQConst;
import com.trainticket.dao.main.OrderDao;
import com.trainticket.entity.CustomUser;
import com.trainticket.entity.Order;
import com.trainticket.entity.TtResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/25 11:13 AM
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ValueOperations<String, Object> valueOperations;

    @PostMapping("/upload")
    public TtResponse<String> uploadOrder(@RequestBody Order order, @CookieValue("TT_token") String token){
        try {
            List<Order> ods = orderDao.findByPsIdTime(order.getPassenger_id(), order.getLeave_time(), order.getArrive_time());
            if (ods != null && ods.size() > 0) {
                return new TtResponse<>(1000, "该乘客在此时间段已有订单", "");
            }
            CustomUser user = (CustomUser) valueOperations.get(token);
            order.setCustomer_id(user.getId());
            ObjectMapper objectMapper = new ObjectMapper();
            log.info("## 推送订单: {}", order);
            rabbitTemplate.convertAndSend(MQConst.ORDER_UPLOAD,MQConst.ORDER_UPLOAD_ROUTE, objectMapper.writeValueAsString(order));
            return new TtResponse<>(200, CommonConst.CODE_200_MSG, "");
        } catch (JsonProcessingException e) {
            log.error("## 预定失败：{}", e.toString());
            return new TtResponse<>(500, CommonConst.CODE_500_MSG,"");
        }
    }
}
