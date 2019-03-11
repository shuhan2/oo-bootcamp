package com.thoughtworks.bootcamp.parkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SuperParkingBoy extends ParkingBoy {

  public SuperParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  protected Optional<ParkingLot> pickParkingLot() {
    return parkingLots.stream()
        .max(Comparator.comparingDouble(ParkingLot::getCapacityRate));
  }
}
