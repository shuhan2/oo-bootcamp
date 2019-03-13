package com.thoughtworks.bootcamp.parkingLot;


import java.util.Objects;

public class Ticket {
  private int number;

  public Ticket(int number) {
    this.number = number;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ticket ticket = (Ticket) o;
    return number == ticket.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
