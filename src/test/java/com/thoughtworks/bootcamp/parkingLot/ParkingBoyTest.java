package com.thoughtworks.bootcamp.parkingLot;

import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ParkingBoyTest {

  @Test
  void should_return_ticket_when_give_the_car_to_parking_boy_given_a_car_and_parking_lots_are_not_full() {
    ParkingLot parkingLot1 = new ParkingLot(10);
    ParkingLot parkingLot2 = new ParkingLot(10);
    ParkingBoy parkingBoy = new ParkingBoy(newArrayList(parkingLot1, parkingLot2));
    Car car = new Car(1);

    Ticket ticket = parkingBoy.receive(car);

    assertNotNull(ticket);
  }
}