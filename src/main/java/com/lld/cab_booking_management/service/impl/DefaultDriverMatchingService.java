package com.lld.cab_booking_management.service.impl;

import com.lld.cab_booking_management.dto.Driver;
import com.lld.cab_booking_management.dto.Location;
import com.lld.cab_booking_management.service.IDriverMatchingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultDriverMatchingService implements IDriverMatchingService {

    @Override
    public Driver matchCabToRider(Location sourceLocation, Location destinationLocation, List<Driver> candidateDrivers) {
        return candidateDrivers.get(0);
    }
}
