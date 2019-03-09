package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.ParkingForbidException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {

  private List<ParkingLot> parkingLotList;
  private ParkingBoy parkingBoy;

  @BeforeEach
  void setUp() {
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(1);
    parkingLotList = newArrayList(parkingLot1, parkingLot2);
    parkingBoy = new ParkingBoy(parkingLotList);
  }

  @Test
  void should_return_ticket_when_give_the_car_to_parking_boy_given_a_car_and_parking_lots_are_not_full() {
    Car car = new Car(1);

    Ticket ticket = parkingBoy.receive(car);

    assertNotNull(ticket);
  }

  @Test
  void should_throw_exception_when_give_the_car_to_parking_boy_given_a_car_and_parking_lots_are_full() {
    Car car1 = new Car(1);
    Car car2 = new Car(2);

    parkingBoy.receive(car1);
    parkingBoy.receive(car2);

    Car parkingCar = new Car(3);
    assertThrows(ParkingForbidException.class, () -> parkingBoy.receive(parkingCar));
  }
}