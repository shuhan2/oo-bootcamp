package com.thoughtworks.bootcamp.parkingLot;

import java.util.List;
import java.util.Optional;

public class GeneralParkingBoy extends ParkingBoy {

  public GeneralParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
  }

  @Override
  protected Optional<ParkingLot> pickParkingLot() {
    return parkingLots.stream()
        .filter(parkingLot -> !parkingLot.isFull())
        .findAny();
  }

}
