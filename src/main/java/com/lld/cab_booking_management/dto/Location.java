package com.lld.cab_booking_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Location {
   private Double locationX;
   private Double locationY;

   public Double distance(Location location2) {
      return Math.sqrt(Math.pow(this.locationX - location2.locationX, 2) + Math.pow(this.locationY - location2.locationY, 2));
   }
}
