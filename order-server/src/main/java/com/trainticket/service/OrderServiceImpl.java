package com.trainticket.service;

import com.trainticket.constant.CommonConst;
import com.trainticket.dao.main.OrderDao;
import com.trainticket.entity.Order;
import com.trainticket.entity.TtResponse;
import com.trainticket.job.OrderDelTimer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/29 4:32 PM
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDelTimer orderDelTimer;

    @Override
    public TtResponse<String> saveOrder(Order order) {
        List<Order> ods = orderDao.findByPsIdTime(order.getPassenger_id(), order.getLeave_time(), order.getArrive_time());
        if (ods != null && ods.size() > 0) {
            return new TtResponse<>(1000, "该乘客在此时间段已有订单", "");
        }
        orderDao.insert(order);
        orderDelTimer.delOrderAfterMinutes(order.getId());
        return new TtResponse<>(200, CommonConst.CODE_200_MSG, "");
    }
}
