package com.thoughtworks.bootcamp.parkingLot;

public class ParkingLot {

  public Boolean isFull() {
    return false;
  }

  public Ticket park(boolean isFull, Car car) {
    if (isFull) {
      return null;
    }
    return new Ticket(1);
  }
}
