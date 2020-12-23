package com.trainticket.dao;

import com.trainticket.entity.TimeTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @Author user
 * @Date 2020/12/23 7:57 PM
 * @Version 1.0
 */
@Component
public interface TimeTableDao {
    List<TimeTable> findTimeTable(@Param("leaveStationId") Integer leaveStationId,
                                  @Param("arriveStationId") Integer arriveStationId,
                                  @Param("minDate") Date minDate,
                                  @Param("maxDate") Date maxDate);
}
