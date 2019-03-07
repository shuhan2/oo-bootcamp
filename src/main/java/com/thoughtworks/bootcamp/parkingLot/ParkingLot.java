package com.thoughtworks.bootcamp.parkingLot;

public class ParkingLot {

  public Boolean isFull() {
    return false;
  }

  public Ticket park(boolean isFull, Car car) {
    return new Ticket(1);
  }
}
