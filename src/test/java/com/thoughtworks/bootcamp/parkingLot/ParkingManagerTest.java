package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingManagerTest {

  @Test
  void should_return_ticket_when_park_car_given_parking_manager_has_parking_boys_that_has_valid_size() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1),
                                                                new ParkingLot(2)));
    Parkable parkingManager = new ParkingManager(newArrayList(), Arrays.asList(parkingBoy));

    Car car = new Car(1);

    Ticket ticket = parkingManager.park(car);
    assertNotNull(ticket);
  }

  @Test
  void should_throw_exception_when_park_car_given_both_parking_manager_and_parking_boy_has_no_valid_size() {
    List<ParkingLot> parkingLots = Arrays.asList(new ParkingLot(1));
    ParkingBoy parkingBoy = new GeneralParkingBoy(parkingLots);
    Parkable parkingManager = new ParkingManager(newArrayList(new ParkingLot(1)), Arrays.asList(parkingBoy));

    parkingManager.park(new Car(1));
    parkingManager.park(new Car(2));

    assertThrows(ParkingLotFullException.class, () -> parkingManager.park(new Car(3)));
  }

  @Test
  void should_return_ticket_when_park_car_given_parking_manager_has_valid_size_and_parking_boy_has_no_valid_size() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1)));
    Parkable parkingManager = new ParkingManager(newArrayList(new ParkingLot(1)), Arrays.asList(parkingBoy));
    parkingManager.park(new Car(1));

    Ticket ticket = parkingManager.park(new Car(2));

    assertNotNull(ticket);
  }

  @Test
  void should_return_car_when_fetch_car_given_car_is_parked_in_parking_lots() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1)));
    Parkable parkingManager = new ParkingManager(newArrayList(new ParkingLot(1)), Arrays.asList(parkingBoy));

    Car car = new Car(1);
    Ticket ticket = parkingManager.park(car);

    assertEquals(car, parkingManager.fetch(ticket));
  }

  @Test
  void should_throw_exception_when_fetch_car_given_ticket_is_valid() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1)));
    Parkable parkingManager = new ParkingManager(newArrayList(new ParkingLot(1)), Arrays.asList(parkingBoy));

    Car car = new Car(1);
    parkingManager.park(car);

    assertThrows(InvalidTicketException.class, () -> parkingManager.fetch(new Ticket(2)));
  }

  @Test
  void should_throw_exception_when_fetch_car_given_ticket_is_used_the_second_time() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1)));
    Parkable parkingManager = new ParkingManager(newArrayList(new ParkingLot(1)), Arrays.asList(parkingBoy));

    Car car = new Car(1);
    Ticket ticket = parkingManager.park(car);
    parkingManager.fetch(ticket);

    assertThrows(InvalidTicketException.class, () -> parkingManager.fetch(ticket));
  }
}