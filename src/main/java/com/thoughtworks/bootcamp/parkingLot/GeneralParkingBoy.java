package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.ParkingForbidException;
import java.util.List;

public class GeneralParkingBoy extends ParkingBoy {

  private List<ParkingLot> parkingLots;

  public GeneralParkingBoy(List<ParkingLot> parkingLots) {
    super(parkingLots);
    this.parkingLots = parkingLots;
  }

  public Ticket park(Car car) {
    return parkingLots.stream()
        .filter(parkingLot -> !parkingLot.isFull())
        .findAny()
        .orElseThrow(ParkingForbidException::new)
        .park(car);
  }

}
