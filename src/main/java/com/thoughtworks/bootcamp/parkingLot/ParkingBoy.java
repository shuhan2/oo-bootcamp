package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.ParkingForbidException;
import java.util.List;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;
  private int availableSize;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
    this.availableSize = parkingLots.stream().map(ParkingLot::getSize).reduce(0, (previousSize, currentSize) -> previousSize + currentSize);
  }

  public Ticket receive(Car car) {
    if (this.availableSize <= 0) {
      throw new ParkingForbidException();
    }
    this.availableSize--;
    return new Ticket(1);

  }
}
