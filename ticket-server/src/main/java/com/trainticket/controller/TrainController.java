package com.trainticket.controller;

import com.trainticket.entity.Train;
import com.trainticket.entity.TtResponse;
import lombok.extern.slf4j.Slf4j;
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
    @PostMapping("/search")
    public TtResponse<List<Train>> searchTrain(@RequestBody Train train){
        return null;
    }
}
