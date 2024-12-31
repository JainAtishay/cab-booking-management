package com.lld.cab_booking_management.service.impl;

import com.lld.cab_booking_management.dto.Driver;
import com.lld.cab_booking_management.dto.Location;
import com.lld.cab_booking_management.service.ICabManagerService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DriverManagerService implements ICabManagerService {

    Map<String, Driver> drivers = new HashMap<>();

    public Driver createDriver(Driver driver){
        if(drivers.containsKey(driver.getId())){
            throw new RuntimeException("driver already exist");
        }

        return drivers.put(driver.getId(), driver);
    }

    public Driver getDriver(String driverId){
        if(!drivers.containsKey(driverId)){
            throw new RuntimeException("driver not present");
        }

        return drivers.get(driverId);
    }

    public List<Driver> getAllNearbyAvailableDrivers(Location fromPoint, Double maxLocationDiff){
        return drivers.values()
                .stream()
                .filter(driver ->
                driver.isAvailable()
                        && driver.getLocation().distance(fromPoint) <= maxLocationDiff)
                .collect(Collectors.toList());
    }

    public void updateCabLocation(@NonNull final String driverId, @NonNull final Location newLocation) {
        if (!drivers.containsKey(driverId)) {
            throw new RuntimeException("driver not found");
        }
        drivers.get(driverId).setLocation(newLocation);
    }
}
