package com.thoughtworks.bootcamp.parkingLot;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingManagerTest {

  @Test
  void name() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1),
                                                                new ParkingLot(2)));
    Parkable parkingMan = new ParkingManager(null, Arrays.asList(parkingBoy));

    Car car = new Car(1);

    Ticket ticket = parkingMan.park(car);
    assertNotNull(ticket);
  }
}