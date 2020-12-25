package com.trainticket.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author user
 * @Date 2020/12/23 7:19 PM
 * @Version 1.0
 */
public class DateUtil {
    private DateUtil(){}
    public static Date getSecondMorning(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE, 1);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }

    public static Date getMorning(Date date){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }
}
