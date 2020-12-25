package com.trainticket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trainticket.constant.MQConst;
import com.trainticket.dao.main.OrderDao;
import com.trainticket.entity.Order;
import com.trainticket.handler.TtMQConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author user
 * @Date 2020/12/25 3:09 PM
 * @Version 1.0
 */
@Component
@Slf4j
@RabbitListener(queues = {MQConst.ORDER_UPLOAD},concurrency = "4")
public class OrderConsumer implements TtMQConsumer {
    @Autowired
    private OrderDao orderDao;

    @Override
    @RabbitHandler
    public void consume(String msg) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(msg, Order.class);
        orderDao.insert(order);
        log.info("## 新订单：{}", order);
    }
}
