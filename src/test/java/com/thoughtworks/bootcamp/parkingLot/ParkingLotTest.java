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
}
