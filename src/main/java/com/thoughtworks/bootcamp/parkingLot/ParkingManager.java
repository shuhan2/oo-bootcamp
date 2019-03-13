package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

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
    if (isEmpty(parkingBoys) || parkingBoys.stream().noneMatch(ParkingBoy::hasParkingSize)) {
      return this.parkingLots.stream()
          .filter(parkingLot -> !parkingLot.isFull())
          .findAny()
          .orElseThrow(ParkingLotFullException::new)
          .park(car);
    }
    return parkingBoys.stream()
        .filter(ParkingBoy::hasParkingSize)
        .findAny()
        .orElseGet(null)
        .park(car);
  }

  @Override
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
