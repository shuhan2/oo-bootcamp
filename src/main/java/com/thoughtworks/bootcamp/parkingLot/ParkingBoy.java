package com.thoughtworks.bootcamp.parkingLot;

import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket receive(Car car) {
    return new Ticket(1);
  }
}
