package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.List;

public class ParkingManager implements Parkable {
  List<ParkingLot> parkingLots;
  List<ParkingBoy> parkingBoys;

  public ParkingManager(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
    this.parkingLots = parkingLots;
    this.parkingBoys = parkingBoys;
  }

  @Override
  public Ticket park(Car car) {
    return parkingBoys.stream()
        .filter(ParkingBoy::hasParkingSize)
        .findAny()
        .orElseThrow(ParkingLotFullException::new)
        .park(car);
  }

  @Override
  public Car fetch(Ticket ticket) {
    return null;
  }
}
