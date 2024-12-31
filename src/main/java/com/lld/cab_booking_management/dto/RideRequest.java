package com.lld.cab_booking_management.dto;


import lombok.Data;

@Data
public class RideRequest {
    private String riderId;
    private Double sourceLocationX;
    private Double sourceLocationY;
    private Double destinationLocationX;
    private Double destinationLocationY;
}
