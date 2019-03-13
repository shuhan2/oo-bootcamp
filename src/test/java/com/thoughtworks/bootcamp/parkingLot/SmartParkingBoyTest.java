package com.thoughtworks.bootcamp.parkingLot;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartParkingBoyTest {

  private ParkingLot parkingLot1;
  private ParkingLot parkingLot2;
  private List<ParkingLot> parkingLots;
  SmartParkingBoy smartParkingBoy;

  @BeforeEach
  void setUp() {
    parkingLot1 = new ParkingLot(1);
    parkingLot2 = new ParkingLot(2);
    parkingLots = newArrayList(parkingLot1, parkingLot2);
    smartParkingBoy = new SmartParkingBoy(parkingLots);
  }

  @Test
  void should_return_ticket_and_verify_parking_car_to_parking_lot_has_more_space_when_park_to_parking_boy_given_a_car_and_parking_lots_has_different_space() {
    smartParkingBoy = new SmartParkingBoy(newArrayList(parkingLot1, parkingLot2));
    Car car = new Car(1);

    Ticket ticket = smartParkingBoy.park(car);

    assertTrue(parkingLot2.isCarExist(ticket));
  }

  @Test
  void should_return_ticket_and_verify_car_park_into_first_parking_lot_when_park_to_parking_boy_given_a_car_and_same_parking_space() {
    parkingLot2 = new ParkingLot(1);
    smartParkingBoy = new SmartParkingBoy(newArrayList(parkingLot1, parkingLot2));
    Car car = new Car(1);

    Ticket ticket = smartParkingBoy.park(car);

    assertTrue(parkingLot1.isCarExist(ticket));
  }
}