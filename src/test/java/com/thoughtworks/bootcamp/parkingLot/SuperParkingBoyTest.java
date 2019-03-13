package com.thoughtworks.bootcamp.parkingLot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SuperParkingBoyTest {

  @Test
  void should_return_ticket_and_park_car_in_the_correct_parking_lot_When_park_given_a_car_and_parking_lots_has_different_capacity_rate() {
    ParkingLot parkingLot1 = new ParkingLot(2);
    Car existedCar = new Car(1);
    parkingLot1.park(existedCar);

    ParkingLot parkingLot2 = new ParkingLot(2);
    SuperParkingBoy superParkingBoy = new SuperParkingBoy(newArrayList(parkingLot1, parkingLot2));
    Car paringCar = new Car(2);

    Ticket ticket = superParkingBoy.park(paringCar);

    assertNotNull(ticket);
    assertTrue(parkingLot2.isCarExist(ticket));
  }
}