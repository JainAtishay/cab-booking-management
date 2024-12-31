package com.lld.cab_booking_management.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {
   private String id;
   private String name;
   private Cab cab;
   private boolean isAvailable = true;
   @JsonBackReference
   private Ride currentRide;
   private Location location;

   public void assignRide(Ride ride){
      this.currentRide = ride;
      this.isAvailable = false;
   }

   public void endRide(){
      this.currentRide.endRide();
      this.currentRide = null;
      this.isAvailable = true;
   }
}
