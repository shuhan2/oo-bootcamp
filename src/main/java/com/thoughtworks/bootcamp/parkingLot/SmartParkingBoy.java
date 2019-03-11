package com.thoughtworks.bootcamp.parkingLot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  public Ticket park(Car car) {
    return parkingLots.stream()
        .max(Comparator.comparingInt(ParkingLot::getAvailableSize))
        .orElseGet(null)
        .park(car);
  }
}
