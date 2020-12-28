package com.trainticket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.trainticket.constant.MQConst;
import com.trainticket.dao.main.OrderDao;
import com.trainticket.entity.Order;
import com.trainticket.handler.TtMQConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author user
 * @Date 2020/12/25 3:09 PM
 * @Version 1.0
 */
@Component
@Slf4j
public class OrderConsumer implements TtMQConsumer {
    @Autowired
    private OrderDao orderDao;

    @Override
    @RabbitListener(queues = {MQConst.ORDER_UPLOAD},concurrency = "4")
    public void consume(Message msg, Channel channel) throws IOException {
        try {
            log.info("## 接到新订单消息：{}", msg.toString());
            ObjectMapper objectMapper = new ObjectMapper();
            Order order = objectMapper.readValue(msg.getBody(), Order.class);
            orderDao.insert(order);
        }catch (Exception e){
            log.error("## 消费订单消息异常: {}", ExceptionUtils.getStackTrace(e));
            channel.basicReject(msg.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
