package com.lld.cab_booking_management.service.impl;

import com.lld.cab_booking_management.dto.Location;
import com.lld.cab_booking_management.service.IPricingService;
import org.springframework.stereotype.Service;

@Service
public class DefaultPricingService implements IPricingService {
    @Override
    public Double fetchPricing(Location sourceLocation, Location destinationLocation) {
        return sourceLocation.distance(destinationLocation) * 10.0;
    }
}
