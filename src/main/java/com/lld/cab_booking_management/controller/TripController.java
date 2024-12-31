package com.lld.cab_booking_management.controller;

import com.lld.cab_booking_management.dto.Ride;
import com.lld.cab_booking_management.dto.RideRequest;
import com.lld.cab_booking_management.service.impl.TripManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripController {

    @Autowired
    private TripManagerService tripManagerService;

    @RequestMapping(value = "/register/trip", method = RequestMethod.POST)
    public ResponseEntity<Ride> createTrip(@RequestBody RideRequest rideRequest) {
        Ride ride = tripManagerService.createTrip(rideRequest);
        return ResponseEntity.ok(ride);
    }

    @RequestMapping(value = "/end/trip", method = RequestMethod.POST)
    public void endTrip(@RequestBody String driverId) {
        tripManagerService.endTrip(driverId);
    }
}