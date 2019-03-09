package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingForbidException;
import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

public class ParkingBoy {

  private List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public Ticket park(Car car) {
    return parkingLots.stream()
        .filter(parkingLot -> !parkingLot.isFull())
        .findAny()
        .orElseThrow(ParkingForbidException::new)
        .park(car);
  }

  public Car fetch(Ticket ticket) {
    if (isEmpty(ticket)) {
      throw new InvalidTicketException();
    }
    return parkingLots.stream()
        .filter(parkingLot -> parkingLot.isCarExist(ticket))
        .findAny()
        .orElseThrow(InvalidTicketException::new)
        .fetch(ticket);
  }
}
