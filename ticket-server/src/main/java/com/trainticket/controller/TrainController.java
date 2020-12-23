package com.trainticket.controller;

import com.trainticket.entity.Train;
import com.trainticket.entity.TtResponse;
import com.trainticket.service.TrainService;
import com.trainticket.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/18 7:54 PM
 * @Version 1.0
 */
@RestController
@RequestMapping("/train")
@Slf4j
public class TrainController {
    @Autowired
    TrainService trainService;

    @PostMapping("/search")
    public TtResponse<List<Train>> searchTrain(@RequestBody Train train){
        try {
            List<Train> trains = trainService.searchTrain(train);
            return new TtResponse<>(200, "success", trains);
        }catch (Exception e){
            log.error("## 获取车次信息失败：{},{}", train, e);
            return new TtResponse<>(500, "服务器错误，请稍后重试！", null);
        }
    }
}
