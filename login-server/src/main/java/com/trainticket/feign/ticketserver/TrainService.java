package com.trainticket.feign.ticketserver;

import com.trainticket.entity.Train;
import com.trainticket.entity.TtResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/18 7:13 PM
 * @Version 1.0
 */
@Component
@FeignClient("ticket-server")
public interface TrainService {
    @PostMapping("/train/search")
    TtResponse<List<Train>> searchTrain(Train train);
}
