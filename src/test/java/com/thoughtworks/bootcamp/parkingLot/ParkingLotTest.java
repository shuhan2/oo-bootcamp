package com.thoughtworks.bootcamp.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  ParkingLot parkingLot;

  @BeforeEach
  void setUp() {
    parkingLot = new ParkingLot();
  }

  @Test
  void should_get_parking_lot_is_not_full_when_call_is_full_method_given_not_any_car_have_parked_in() {
    Boolean isFull = parkingLot.isFull();
    assertEquals(false, isFull);
  }

  @Test
  void should_client_get_a_ticket_no_when_call_park_method_given_parking_lot_is_not_full_and_car() {
    Car car = new Car();
    Ticket ticket = parkingLot.park(false, car);
    assertNotNull(ticket);
    assertEquals(1, ticket.getNumber());
  }

  @Test
  void should_client_get_nothing_when_call_park_method_given_parking_lot_is_full_and_car() {
    Car car = new Car();
    Ticket ticket = parkingLot.park(true, car);
    assertNull(ticket);
  }
}
