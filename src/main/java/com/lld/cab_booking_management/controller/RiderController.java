package com.lld.cab_booking_management.controller;

import com.lld.cab_booking_management.dto.Rider;
import com.lld.cab_booking_management.service.impl.RiderManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderController {

    @Autowired
    private RiderManagerService riderManagerService;

    @RequestMapping(value = "/register/rider", method = RequestMethod.POST)
    public Rider registerRider(@RequestBody Rider rider) {
        return riderManagerService.createRider(rider);
    }
}