package com.thoughtworks.bootcamp.parkingLot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {

  private List<ParkingLot> parkingLotList;

  public SmartParkingBoy(List<ParkingLot> parkingLotList) {
    this.parkingLotList = parkingLotList;
  }

  public Ticket park(Car car) {
    return parkingLotList.stream()
        .max(Comparator.comparingInt(ParkingLot::getAvailableSize))
        .orElseGet(null)
        .park(car);
  }
}
