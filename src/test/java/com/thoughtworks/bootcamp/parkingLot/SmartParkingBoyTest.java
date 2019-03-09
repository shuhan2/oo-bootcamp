package com.thoughtworks.bootcamp.parkingLot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartParkingBoyTest {

  @Test
  void should_return_ticket_and_verify_parking_car_to_parking_lot_has_more_space_when_park_to_parking_boy_given_a_car_and_parking_lots_has_different_space() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(2);
    SmartParkingBoy smartParkingBoy = new SmartParkingBoy(newArrayList(parkingLot1, parkingLot2));
    Car car = new Car(1);

    Ticket ticket = smartParkingBoy.park(car);

    assertNotNull(ticket);
    assertTrue(parkingLot2.isCarExist(ticket));
  }
}