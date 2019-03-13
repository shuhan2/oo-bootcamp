package com.thoughtworks.bootcamp.parkingLot;

import com.thoughtworks.bootcamp.exceptions.ParkingLotFullException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingManagerTest {

  @Test
  void should_return_ticket_when_park_car_given_parking_manager_has_parking_boys_that_has_valid_size() {
    ParkingBoy parkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1),
                                                                new ParkingLot(2)));
    Parkable parkingManager = new ParkingManager(null, Arrays.asList(parkingBoy));

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
}