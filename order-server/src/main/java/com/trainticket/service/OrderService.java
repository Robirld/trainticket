package com.trainticket.service;

import com.trainticket.entity.Order;
import com.trainticket.entity.TtResponse;

/**
 * @Author user
 * @Date 2020/12/29 4:31 PM
 * @Version 1.0
 */
public interface OrderService {
    TtResponse<String> saveOrder(Order order);
}
