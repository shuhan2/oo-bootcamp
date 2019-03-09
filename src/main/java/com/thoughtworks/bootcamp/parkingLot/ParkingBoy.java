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
    return parkingLots.stream()
        .map(parkingLot -> {
          try {
            return parkingLot.fetch(ticket);
          } catch (InvalidTicketException exception) {
            return null;
          }
        })
        .filter(car -> !isEmpty(car))
        .findAny()
        .orElseThrow(InvalidTicketException::new);
  }
}
