package com.lld.cab_booking_management.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
public class Ride {
    private Rider rider;
    @JsonManagedReference
    private Driver driver;
    private RideStatus rideStatus;
    private Double price;
    private Location source;
    private Location destination;

    public void endRide() {
        this.rideStatus = RideStatus.COMPLETED;
    }
}
