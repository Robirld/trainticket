package com.trainticket.handler;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

import java.io.IOException;

/**
 * @Author user
 * @Date 2020/12/25 3:10 PM
 * @Version 1.0
 */
public interface TtMQConsumer {
    default void consume(Message msg, Channel channel) throws IOException {};
}
