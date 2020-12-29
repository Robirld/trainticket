package com.trainticket.dao.main;

import com.trainticket.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author user
 * @Date 2020/12/25 4:04 PM
 * @Version 1.0
 */
@Component
public interface OrderDao {
    void insert(Order order);

    List<Order> findByPsIdTime(@Param("passenger_id") Integer passengerId,
                               @Param("leave_time") Date leaveTime,
                               @Param("arrive_time") Date arriveTime);

    @Select("select * from tt_order where id = #{id} and del_flag = 0")
    Order findById(@Param("id") Integer id);

    @Update("update tt_order set status = 2 where id = #{id}")
    void delete(@Param("id") Integer id);
}
