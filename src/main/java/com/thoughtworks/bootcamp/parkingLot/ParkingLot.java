package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ParkingLot {

  private int size;
  private Map<Ticket, Car> carMap = new HashMap<>();

  public ParkingLot(int size) {
    this.size = size;
  }

  public int getAvailableSize() {
    return this.size - this.carMap.size();
  }

  public float getCapacityRate() {
    return getAvailableSize() / (float) size;
  }

  public Boolean isFull() {
    return carMap.size() == this.size;
  }

  public Ticket park(Car car) {
    if (isFull()) {
      throw new ParkingLotFullException();
    }
    Ticket ticket = new Ticket(car.getNumber());
    carMap.put(ticket, car);
    return ticket;
  }

  public Car fetch(Ticket ticket) {
    Car removedCar = carMap.get(ticket);
    if (isEmpty(removedCar)) {
      throw new InvalidTicketException();
    }
    carMap.remove(ticket);
    return removedCar;
  }

  public Boolean isCarExist(Ticket ticket) {
    return carMap.containsKey(ticket);
  }
}
