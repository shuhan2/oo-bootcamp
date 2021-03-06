package com.thoughtworks.bootcamp.parkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {

  public SmartParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }



  @Override
  protected Optional<ParkingLot> pickParkingLot() {
    return parkingLots.stream()
        .max(Comparator.comparingInt(ParkingLot::getAvailableSize));
  }
}
