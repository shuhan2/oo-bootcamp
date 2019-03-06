package com.thoughtworks.bootcamp.fizzBuzz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzBuzzTest {
  private FizzBuzz fizzBuzz;

  @BeforeEach
  void setUp() {
    fizzBuzz = new FizzBuzz();
  }

  @Test
  void should_return_fizz_when_call_convert_method_given_number_6() {
    assertEquals("Fizz", fizzBuzz.convert(6)) ;
  }
}