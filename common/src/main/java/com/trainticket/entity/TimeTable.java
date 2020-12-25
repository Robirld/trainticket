package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author user
 * @Date 2020/12/23 2:32 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeTable {
    private Integer id;
    private String train_number;
    private Date train_date;
    private Station station;
    private Date leave_time;
    private Date arrive_time;
    private Integer wait_time;
    private Integer current_tickit_num;
}
