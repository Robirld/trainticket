package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author user
 * @Date 2020/12/15 12:01 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUser {
    private Integer id;
    private String username;
    private String password;
    private String phone_number;
    private boolean deleted;
}
