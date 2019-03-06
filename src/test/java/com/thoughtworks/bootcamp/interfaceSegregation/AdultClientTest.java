package com.thoughtworks.bootcamp.interfaceSegregation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdultClientTest {
  private AdultClient adultClient;

  @BeforeEach
  void setUp() {
    adultClient = new AdultClient();
  }

  @Test
  void should_return_eat_when_call_eat_given_adult_client() {
    String result = adultClient.eat();
    assertEquals("eat", result);
  }

  @Test
  void should_return_drink_when_call_drink_given_adult_client() {
    String result = adultClient.drink();
    assertEquals("drink", result);
  }

  @Test
  void should_return_snore_when_call_snore_given_adult_client() {
    String result = adultClient.snore();
    assertEquals("snore", result);
  }
}