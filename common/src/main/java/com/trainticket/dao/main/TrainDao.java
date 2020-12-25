package com.trainticket.dao.main;

import com.trainticket.entity.Train;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/22 4:53 PM
 * @Version 1.0
 */
@Component
public interface TrainDao {
    List<Train> findLeaveArriveStation(@Param("startCity") String startCity, @Param("endCity") String endCity);
}
