package com.thoughtworks.bootcamp.interfaceSegregation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BabyClientTest {
  private BabyClient babyClient;

  @BeforeEach
  void setUp() {
    babyClient = new BabyClient();
  }

  @Test
  void should_return_crawl_when_call_crawl_given_baby_client() {
    String result = babyClient.crawl();
    assertEquals("crawl", result);
  }

  @Test
  void should_return_eat_when_call_eat_given_baby_client() {
    String result = babyClient.eat();
    assertEquals("eat", result);
  }

  @Test
  void should_return_drink_when_call_drink_given_baby_client() {
    String result = babyClient.drink();
    assertEquals("drink", result);
  }

  @Test
  void should_return_cry_when_call_cry_given_baby_client() {
    String result = babyClient.cry();
    assertEquals("cry", result);
  }

  @Test
  void should_return_snore_when_call_snore_given_baby_client() {
    String result = babyClient.snore();
    assertEquals("snore", result);
  }
}
