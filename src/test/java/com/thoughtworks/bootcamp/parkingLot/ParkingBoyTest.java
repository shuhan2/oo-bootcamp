package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.InvalidTicketException;
import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {

  @ParameterizedTest
  @MethodSource("parkingBoyProvider")
  void should_return_ticket_when_park_to_parking_boy_given_parking_lots_are_not_full(Function<List<ParkingLot>, ParkingBoy> parkingBoyCreator) {
    ParkingBoy parkingBoy = parkingBoyCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    Ticket ticket = parkingBoy.park(new Car(1));

    assertNotNull(ticket);
  }

  @ParameterizedTest
  @MethodSource("parkingBoyProvider")
  void should_throw_exception_when_park_to_parking_boy_given_parking_lots_are_full(Function<List<ParkingLot>, ParkingBoy> parkingBoyCreator) {
    ParkingBoy parkingBoy = parkingBoyCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(1)));

    parkingBoy.park(new Car(1));
    parkingBoy.park(new Car(2));

    Car parkingCar = new Car(3);
    assertThrows(ParkingLotFullException.class, () -> parkingBoy.park(parkingCar));
  }

  @ParameterizedTest
  @MethodSource("parkingBoyProvider")
  void should_return_car_when_fetch_given_valid_ticket_to_parking_boy(Function<List<ParkingLot>, ParkingBoy> parkingBoyCreator) {
    ParkingBoy parkingBoy = parkingBoyCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    Car parkingCar = new Car(1);

    Ticket ticket = parkingBoy.park(parkingCar);
    Car fetchedCar = parkingBoy.fetch(ticket);
    assertEquals(parkingCar, fetchedCar);
  }

  @ParameterizedTest
  @MethodSource("parkingBoyProvider")
  void should_return_car_when_fetch_given_invalid_ticket(Function<List<ParkingLot>, ParkingBoy> parkingBoyCreator) {
    ParkingBoy parkingBoy = parkingBoyCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    parkingBoy.park(new Car(1));
    assertThrows(InvalidTicketException.class, () -> {
      parkingBoy.fetch(new Ticket(9999));
    });
  }

  @ParameterizedTest
  @MethodSource("parkingBoyProvider")
  void should_return_car_when_fetch_given_expired_ticket(Function<List<ParkingLot>, ParkingBoy> parkingBoyCreator) {
    ParkingBoy parkingBoy = parkingBoyCreator.apply(
        Arrays.asList(new ParkingLot(1),
                      new ParkingLot(2)));

    Ticket ticket = parkingBoy.park(new Car(1));
    parkingBoy.fetch(ticket);
    assertThrows(InvalidTicketException.class, () -> {
      parkingBoy.fetch(ticket);
    });
  }

  private static List<Function<List<ParkingLot>, ParkingBoy>> parkingBoyProvider() {
    return Arrays.asList(GeneralParkingBoy::new, SmartParkingBoy::new, SuperParkingBoy::new);
  }

}
