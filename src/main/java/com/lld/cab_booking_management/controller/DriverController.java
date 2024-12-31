package com.lld.cab_booking_management.controller;

import com.lld.cab_booking_management.dto.Driver;
import com.lld.cab_booking_management.dto.Location;
import com.lld.cab_booking_management.service.impl.DriverManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DriverController {

    @Autowired
    private DriverManagerService driverManagerService;

    @RequestMapping(value = "/register/driver", method = RequestMethod.POST)
    public Driver registerDriver(@RequestBody Driver driver) {
        return driverManagerService.createDriver(driver);
    }

    @RequestMapping(value = "/update/location/{driverId}", method = RequestMethod.POST)
    public void updateDriverLocation(@PathVariable String driverId, @RequestBody Location location) {
         driverManagerService.updateCabLocation(driverId, location);
    }
}