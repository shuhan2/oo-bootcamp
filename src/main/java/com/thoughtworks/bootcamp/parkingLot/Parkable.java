package com.thoughtworks.bootcamp.parkingLot;

public interface Parkable {
  Car fetch(Ticket ticket);

  Ticket park(Car car);

  boolean isFull();
}
