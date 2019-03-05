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
  void should_return_Crawl_When_Call_Crawl_Given_BabyClient() {
    String result = babyClient.Crawl();
    assertEquals("Crawl", result);
  }
}