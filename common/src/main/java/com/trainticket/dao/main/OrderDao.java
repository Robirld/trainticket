package com.trainticket.dao.main;

import com.trainticket.entity.Order;
import org.springframework.stereotype.Component;

/**
 * @Author user
 * @Date 2020/12/25 4:04 PM
 * @Version 1.0
 */
@Component
public interface OrderDao {
    int insert(Order order);
}
