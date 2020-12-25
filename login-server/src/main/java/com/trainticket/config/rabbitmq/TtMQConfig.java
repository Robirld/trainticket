package com.trainticket.config.rabbitmq;

import com.trainticket.constant.MQConst;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author user
 * @Date 2020/12/25 10:58 AM
 * @Version 1.0
 */
@Configuration
public class TtMQConfig {
    @Bean
    public Queue orderUploadQueue(){
        return new Queue(MQConst.ORDER_UPLOAD, true);
    }

    @Bean
    public DirectExchange orderUploadExchange(){
        return new DirectExchange(MQConst.ORDER_UPLOAD);
    }

    @Bean
    Binding bindorderUpload(){
        return BindingBuilder.bind(orderUploadQueue()).to(orderUploadExchange()).with(MQConst.ORDER_UPLOAD_ROUTE);
    }
}
