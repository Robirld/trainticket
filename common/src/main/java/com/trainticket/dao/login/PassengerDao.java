package com.trainticket.dao.login;

import com.trainticket.entity.Passenger;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/24 6:37 PM
 * @Version 1.0
 */
@Component
public interface PassengerDao {
    @Select("select * from passenger where del_flag = 0 and customer_id = #{customerId}")
    List<Passenger> findByCustomerId(@Param("customerId") Integer customerId);
}
