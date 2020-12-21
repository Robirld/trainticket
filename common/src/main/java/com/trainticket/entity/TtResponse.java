package com.trainticket.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author user
 * @Date 2020/12/15 4:12 PM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TtResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
}
