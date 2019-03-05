package com.thoughtworks.bootcamp.interfaceSegration;

import com.thoughtworks.bootcamp.interfaceSegregation.BabyClient;
import com.thoughtworks.bootcamp.interfaceSegregation.HumanAble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BabyClientTest {
  private HumanAble babyClient;

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
}
