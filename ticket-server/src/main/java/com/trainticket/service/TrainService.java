package com.trainticket.service;

import com.trainticket.entity.Train;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/21 10:33 AM
 * @Version 1.0
 */
public interface TrainService {
    List<Train> searchTrain(Train train);
}
