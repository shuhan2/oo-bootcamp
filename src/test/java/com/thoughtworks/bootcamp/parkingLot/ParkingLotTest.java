package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {
  ParkingLot parkingLot;

  @BeforeEach
  void setUp() {
    parkingLot = new ParkingLot(20);
  }

  @Test
  void should_client_get_a_ticket_no_when_call_park_method_given_parking_lot_is_not_full_and_car() {
    Car car = new Car(1);

    Ticket ticket = parkingLot.park(car);

    assertNotNull(ticket);
    assertEquals(1, ticket.getNumber());
  }

  @Test
  void should_client_get_nothing_when_call_park_method_given_parking_lot_is_full_and_car() {
    parkingLot = new ParkingLot(1);
    Car existCar = new Car(111);
    parkingLot.park(existCar);
    Car car = new Car(1);

    assertThrows(ParkingLotFullException.class, () -> parkingLot.park(car));
  }

  @Test
  void should_client_get_his_car_when_call_fetch_method_given_valid_ticket() {
    Car parkingCar =  new Car(1);
    Ticket ticket = parkingLot.park(parkingCar);

    Car fetchCar = parkingLot.fetch(ticket);

    assertEquals(parkingCar, fetchCar);
  }

  @Test
  void should_client_can_not_get_his_car_when_call_fetch_method_given_invalid_ticket() {
    Car parkingCar =  new Car(1);
    parkingLot.park(parkingCar);
    Ticket invalidTicket = new Ticket(2);

    assertThrows(InvalidTicketException.class, () -> parkingLot.fetch(invalidTicket));

  }

  @Test
  void should_client_get_ticket_when_park_given_that_full_parking_not_is_fetched_a_car() {
    parkingLot = new ParkingLot(1);
    Car existCar = new Car(111);
    Ticket existedTicket = parkingLot.park(existCar);
    parkingLot.fetch(existedTicket);
    Car car = new Car(1);

    Ticket ticket = parkingLot.park(car);

    assertNotNull(ticket);
  }
}
