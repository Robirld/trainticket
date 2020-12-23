package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author user
 * @Date 2020/12/18 7:23 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    private String number;
    private String startCity;
    private String endCity;
    private Date rideDate;
    private Station leaveStation;
    private Station arriveStation;
    private Date leaveTime;
    private Date arriveTime;
    private Spend spend;
    private List<TimeTable> timeTables = new ArrayList<>();
}
