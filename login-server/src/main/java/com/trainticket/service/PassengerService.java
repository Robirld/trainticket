package com.trainticket.service;

import com.trainticket.dao.PassengerDao;
import com.trainticket.entity.CustomUser;
import com.trainticket.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author user
 * @Date 2020/12/24 6:41 PM
 * @Version 1.0
 */
@Service
public class PassengerService {
    @Autowired
    private PassengerDao passengerDao;

    @Autowired
    private ValueOperations<String, Object> valueOperations;

    public List<Passenger> findByCustomerId(String token){
        CustomUser user = (CustomUser) valueOperations.get(token);
        return passengerDao.findByCustomerId(user.getId());
    }
}
