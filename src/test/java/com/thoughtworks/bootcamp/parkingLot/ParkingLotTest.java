package com.thoughtworks.bootcamp.parkingLot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  ParkingLot parkingLot;

  @BeforeEach
  void setUp() {
    parkingLot = new ParkingLot(20);
  }

  @Test
  void should_get_parking_lot_is_not_full_when_call_is_full_method_given_not_any_car_have_parked_in() {
    Boolean isFull = parkingLot.isFull();
    assertEquals(false, isFull);
  }

  @Test
  void should_client_get_a_ticket_no_when_call_park_method_given_parking_lot_is_not_full_and_car() {
    Map<Ticket, Car> carMap = new HashMap<>();
    parkingLot = new ParkingLot(20, carMap);

    Car car = new Car(1);
    Boolean isFull = parkingLot.isFull();
    Ticket ticket = parkingLot.park(isFull, car);
    assertNotNull(ticket);
    assertEquals(1, ticket.getNumber());
  }

  @Test
  void should_client_get_nothing_when_call_park_method_given_parking_lot_is_full_and_car() {
    Map<Ticket, Car> carMap = new HashMap<>();
    Car existCar = new Car(111);
    Ticket existTicket = new Ticket(111);
    carMap.put(existTicket, existCar);
    parkingLot = new ParkingLot(1, carMap);

    Car car = new Car(1);
    Boolean isFull = parkingLot.isFull();
    Ticket ticket = parkingLot.park(isFull, car);
    assertNull(ticket);
  }

  @Test
  void should_client_get_his_car_when_call_fetch_method_given_valid_ticket() {
    Car parkingCar =  new Car(1);
    Ticket ticket = parkingLot.park(false, parkingCar);

    Car fetchCar = parkingLot.fetch(ticket);

    assertEquals(parkingCar, fetchCar);
  }

  @Test
  void should_client_can_not_get_his_car_when_call_fetch_method_given_invalid_ticket() {
    Map<Ticket, Car> carMap = new HashMap<>();
    parkingLot = new ParkingLot(20, carMap);

    Car parkingCar =  new Car(1);
    Boolean isFull = parkingLot.isFull();
    parkingLot.park(isFull, parkingCar);
    Ticket invalidTicket = new Ticket(2);
    Car fetchCar = parkingLot.fetch(invalidTicket);

    assertNull(fetchCar);
  }
}
