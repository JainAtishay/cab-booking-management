package com.lld.cab_booking_management.service.impl;

import com.lld.cab_booking_management.dto.Rider;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RiderManagerService{

    Map<String, Rider> riders = new HashMap<>();

    public Rider createRider(Rider rider){
        if(riders.containsKey(rider.getId())){
            throw new RuntimeException("riders already exist");
        }

        riders.put(rider.getId(), rider);
        return rider;
    }

    public Rider getRider(String riderId){
        if(!riders.containsKey(riderId)){
            throw new RuntimeException("riders not present");
        }

        return riders.get(riderId);
    }
}
