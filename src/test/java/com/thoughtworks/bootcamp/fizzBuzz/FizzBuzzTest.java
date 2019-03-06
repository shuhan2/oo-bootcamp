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

  @Test
  void should_return_buzz_when_call_convert_method_given_number_10() {
    assertEquals("Buzz", fizzBuzz.convert(10)) ;
  }

  @Test
  void should_return_fizz_buzz_when_call_convert_method_given_number_15() {
    assertEquals("FizzBuzz", fizzBuzz.convert(15)) ;
  }

  @Test
  void should_return_7_when_call_convert_method_given_number_7() {
    assertEquals("7", fizzBuzz.convert(7)) ;
  }
}