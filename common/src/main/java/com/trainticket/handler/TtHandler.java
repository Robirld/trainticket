package com.trainticket.handler;

/**
 * @Author user
 * @Date 2020/12/15 3:11 PM
 * @Version 1.0
 */
public interface TtHandler<T, M> {
    M execute(T t) throws Exception;
}
