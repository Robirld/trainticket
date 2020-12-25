package com.trainticket.handler;

/**
 * @Author user
 * @Date 2020/12/25 3:10 PM
 * @Version 1.0
 */
public interface TtMQConsumer {
    void consume(String msg) throws Exception;
}
