package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

public abstract class ParkingBoy implements Parkable {

  List<ParkingLot> parkingLots;

  public ParkingBoy(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
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

  public Ticket park(Car car) {
    return pickParkingLot()
        .orElseThrow(ParkingLotFullException::new)
        .park(car);
  }

  public boolean isFull() {
    return parkingLots.stream().allMatch(ParkingLot::isFull);
  }

  protected abstract Optional<ParkingLot> pickParkingLot();
}
