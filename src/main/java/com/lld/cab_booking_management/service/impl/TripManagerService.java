package com.lld.cab_booking_management.service.impl;

import com.lld.cab_booking_management.dto.*;
import com.lld.cab_booking_management.service.IDriverMatchingService;
import com.lld.cab_booking_management.service.IPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TripManagerService{

    private static final Double MAX_LOCATION_DIFF = 10.0;

    Map<String, List<Ride>> rides = new HashMap<>();

    @Autowired
    private RiderManagerService riderManagerService;

    @Autowired
    private DriverManagerService driverManagerService;

    @Autowired
    private IDriverMatchingService driverMatchingService;

    @Autowired
    private IPricingService pricingService;

    public Ride createTrip(RideRequest rideRequest){
        Rider rider = riderManagerService.getRider(rideRequest.getRiderId());
        Location source = new Location(rideRequest.getSourceLocationX(), rideRequest.getSourceLocationY());
        Location destination = new Location(rideRequest.getDestinationLocationX(), rideRequest.getDestinationLocationY());
        List<Driver> availableDrivers = driverManagerService.getAllNearbyAvailableDrivers(source, MAX_LOCATION_DIFF);

        Driver selectedDriver = driverMatchingService.matchCabToRider(source, destination, availableDrivers);

        if(Objects.isNull(selectedDriver)){
            throw  new RuntimeException("no cabs available");
        }

        Double price = pricingService.fetchPricing(source,destination);

        Ride ride = new Ride(rider, selectedDriver, RideStatus.PROGRESS, price, source, destination);

        if(!rides.containsKey(ride.getRider().getId())){
            rides.put(ride.getRider().getId(), new ArrayList<>());
        }

        rides.get(ride.getRider().getId()).add(ride);
        selectedDriver.assignRide(ride);

        return ride;
    }

    public void endTrip(String driverId) {
        Driver assignedDriver = driverManagerService.getDriver(driverId);
        assignedDriver.endRide();
    }
}
/*
CREATE RIDE
1. get rider details -> riderService
2. get all available drivers -> driverService
3. match rider to all available drivers using driver matching algorithm -> driverMatchingService
4. fetch pricing details -> pricingStrategy
5. create ride
6. assign trip to cab/driver
 */