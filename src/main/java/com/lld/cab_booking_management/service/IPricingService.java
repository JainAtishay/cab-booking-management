package com.lld.cab_booking_management.service;

import com.lld.cab_booking_management.dto.Driver;
import com.lld.cab_booking_management.dto.Location;

import java.util.List;

public interface IPricingService {

    Double fetchPricing(Location sourceLocation, Location destinationLocation);
}
