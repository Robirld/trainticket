package com.trainticket.controller.ticketserver;

import com.trainticket.entity.Train;
import com.trainticket.entity.TtResponse;
import com.trainticket.service.ticketserver.TrainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/18 7:43 PM
 * @Version 1.0
 */

@RestController
@RequestMapping("/train")
@Slf4j
public class TrainController {
    @Autowired
    private TrainService trainService;

    @PostMapping("/search")
    public TtResponse<List<Train>> searchTrain(@RequestBody Train train){
        try {
            return trainService.searchTrain(train);
        }catch (Exception e){
            log.error("## 请求ticket-server出错：{}",e.getMessage());
            return new TtResponse<>(500, "服务器出错", null);
        }
    }
}
