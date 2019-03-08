package com.thoughtworks.bootcamp.parkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
  private Map<Ticket, Car> carMap = new HashMap<>();

  public Boolean isFull() {
    return false;
  }

  public Ticket park(boolean isFull, Car car) {
    if (isFull) {
      return null;
    }
    Ticket ticket = new Ticket(car.getNumber());
    carMap.put(ticket, car);
    return ticket;
  }

  public Car fetch(Ticket ticket) {
    return carMap.get(ticket);
  }
}
