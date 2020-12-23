package com.trainticket.service;

import com.trainticket.constant.CommonConst;
import com.trainticket.dao.TimeTableDao;
import com.trainticket.dao.TrainDao;
import com.trainticket.entity.Spend;
import com.trainticket.entity.TimeTable;
import com.trainticket.entity.Train;
import com.trainticket.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author user
 * @Date 2020/12/21 10:35 AM
 * @Version 1.0
 */
@Component
public class TrainServiceImpl implements TrainService {
    @Autowired
    TrainDao trainDao;

    @Autowired
    TimeTableDao timeTableDao;

    @Override
    public List<Train> searchTrain(Train train) {
        List<Train> train1 = trainDao.findLeaveArriveStation(train.getStartCity(), train.getEndCity());
        Map<String, Train> trainMap = new HashMap<>();
        train1.forEach(t1 -> {
            List<TimeTable> timeTables = timeTableDao.findTimeTable(
                    t1.getLeaveStation().getId(),
                    t1.getArriveStation().getId(),
                    DateUtil.getMorning(train.getRideDate()),
                    DateUtil.getSecondMorning(train.getRideDate())
            );
            timeTables.forEach(tb -> {
                Train tmp = null;
                if ((tmp = trainMap.get(tb.getTrain_number())) == null){
                    tmp = new Train();
                    tmp.setNumber(tb.getTrain_number());
                    tmp.setLeaveStation(t1.getLeaveStation());
                    tmp.setArriveStation(t1.getArriveStation());
                    trainMap.put(tb.getTrain_number(), tmp);
                }
                tmp.getTimeTables().add(tb);
            });
        });
        List<Train> trains = new ArrayList<>();
        trains.addAll(trainMap.values());
        trains.forEach(t -> {
            t.setRideDate(train.getRideDate());
            t.setStartCity(train.getStartCity());
            t.setEndCity(train.getEndCity());
            t.getTimeTables().forEach(tt -> {
                if (tt.getStation().getId() == t.getLeaveStation().getId()){
                    t.setLeaveTime(tt.getLeave_time());
                }
                if (tt.getStation().getId() == t.getArriveStation().getId()){
                    t.setArriveTime(tt.getArrive_time());
                }
            });
            int spendS = (int) ((t.getArriveTime().getTime() - t.getLeaveTime().getTime()) / 1000);
            Spend spend = new Spend();
            spend.setDay(spendS / CommonConst.DAY_TO_SECONDS);
            spend.setHour((spendS % CommonConst.DAY_TO_SECONDS) / 3600);
            spend.setMinute((spendS % 3600) / 60);
            spend.setSecond(spendS % 60);
            t.setSpend(spend);
        });
        return trains;
    }
}
