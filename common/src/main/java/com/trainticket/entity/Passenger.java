package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author user
 * @Date 2020/12/24 6:16 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
    private Integer id;
    private String name;
    private String id_num;
    private String phone;
    private String role;
    private Integer customer_id;
    private String relation;
}
