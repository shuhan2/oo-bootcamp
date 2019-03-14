package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager extends GeneralParkingBoy implements Parkable {
  List<ParkingBoy> parkingBoys;
  Map<Ticket, Parkable> ticketParkingBoyMap = new HashMap<>();

  public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
    super(parkingLots);
    this.parkingBoys = parkingBoys;
  }

  @Override
  public boolean isFull() {
    return super.isFull() && parkingBoys.stream().allMatch(ParkingBoy::isFull);
  }

  @Override
  public Ticket park(Car car) {
    Parkable parkable = this;
    Ticket ticket;
    try {
      ticket = super.park(car);
    } catch (ParkingLotFullException ex) {
      parkable = this.parkingBoys.stream()
          .filter(boy -> !boy.isFull())
          .findAny()
          .orElseThrow(ParkingLotFullException::new);
      ticket = parkable.park(car);
    }
    ticketParkingBoyMap.put(ticket, parkable);
    return ticket;
  }

  @Override
  public Car fetch(Ticket ticket) {
    Parkable parkable = ticketParkingBoyMap.get(ticket);
    if (parkable == null) {
      throw new InvalidTicketException();
    }
    if (parkable == this) {
      return super.fetch(ticket);
    }
    Car car = parkable.fetch(ticket);
    ticketParkingBoyMap.remove(ticket);
    return car;
  }
}
