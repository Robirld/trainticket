package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String leaveStation;
    private String arriveStation;
    private Date leaveTime;
    private Date arriveTime;
    private Spend spend;
}
