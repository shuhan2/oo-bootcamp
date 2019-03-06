package com.thoughtworks.bootcamp.interfaceSegregation;

public class BabyClient implements HumanAble, BabyAble {

  @Override
  public String crawl() {
    return "crawl";
  }

  @Override
  public String eat() {
    return "eat";
  }

  @Override
  public String drink() {
    return "drink";
  }

  @Override
  public String cry() {
    return "cry";
  }

  @Override
  public String snore() {
    return "snore";
  }
}
