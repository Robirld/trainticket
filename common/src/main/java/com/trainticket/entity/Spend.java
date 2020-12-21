package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author user
 * @Date 2020/12/18 7:40 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spend {
    private int day;
    private int hour;
    private int minute;
    private int second;
}
