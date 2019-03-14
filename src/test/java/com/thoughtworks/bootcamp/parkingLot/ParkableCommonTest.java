package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkableCommonTest {

  @ParameterizedTest
  @MethodSource("parkingManProvider")
  void should_return_ticket_when_park_to_parking_boy_given_parking_lots_are_not_full(Function<List<ParkingLot>, Parkable> parkableCreator) {
    Parkable parkingMan = parkableCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    Ticket ticket = parkingMan.park(new Car(1));

    assertNotNull(ticket);
  }

  @ParameterizedTest
  @MethodSource("parkingManProvider")
  void should_throw_exception_when_park_to_parking_boy_given_parking_lots_are_full(Function<List<ParkingLot>, Parkable> parkableCreator) {
    Parkable parkable = parkableCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(1)));

    parkable.park(new Car(1));
    parkable.park(new Car(2));

    Car parkingCar = new Car(3);
    assertThrows(ParkingLotFullException.class, () -> parkable.park(parkingCar));
  }

  @ParameterizedTest
  @MethodSource("parkingManProvider")
  void should_return_car_when_fetch_given_valid_ticket_to_parking_boy(Function<List<ParkingLot>, Parkable> parkableCreator) {
    Parkable parkingMan = parkableCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    Car parkingCar = new Car(1);

    Ticket ticket = parkingMan.park(parkingCar);
    Car fetchedCar = parkingMan.fetch(ticket);
    assertEquals(parkingCar, fetchedCar);
  }

  @ParameterizedTest
  @MethodSource("parkingManProvider")
  void should_return_car_when_fetch_given_invalid_ticket(Function<List<ParkingLot>, Parkable> parkableCreator) {
    Parkable parkingMan = parkableCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    parkingMan.park(new Car(1));
    assertThrows(InvalidTicketException.class, () -> {
      parkingMan.fetch(new Ticket(9999));
    });
  }

  @ParameterizedTest
  @MethodSource("parkingManProvider")
  void should_return_car_when_fetch_given_expired_ticket(Function<List<ParkingLot>, Parkable> parkableCreator) {
    Parkable parkable = parkableCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    Ticket ticket = parkable.park(new Car(1));
    parkable.fetch(ticket);
    assertThrows(InvalidTicketException.class, () -> {
      parkable.fetch(ticket);
    });
  }

  private static List<Function<List<ParkingLot>, Parkable>> parkingManProvider() {
    return Arrays.asList(GeneralParkingBoy::new,
                         SmartParkingBoy::new,
                         SuperParkingBoy::new,
                         parkingLots -> new ParkingManager(parkingLots, Collections.emptyList()));
  }
}
