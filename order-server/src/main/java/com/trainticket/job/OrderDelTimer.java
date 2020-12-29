package com.trainticket.job;

import com.trainticket.dao.main.OrderDao;
import com.trainticket.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @Author user
 * @Date 2020/12/28 7:49 PM
 * @Version 1.0
 */
@Component
@Slf4j
public class OrderDelTimer {
    @Autowired
    private Environment environment;

    @Autowired
    OrderDao orderDao;

    public void delOrderAfterMinutes(Integer id){
        int gap = Integer.parseInt(environment.getProperty("order.delete.gap"));
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(gap * 60000);
                Order order = orderDao.findById(id);
                if (order != null && order.getPay_time() == null){
                    orderDao.delete(id);
                    log.info("## 取消逾期未支付订单：{}",order);
                }
            } catch (Exception e) {
                log.error("## 删除未支付订单线程异常：id=>{}, error=>{}", id, ExceptionUtils.getStackTrace(e));
            }
        });
        thread.start();
    }
}
