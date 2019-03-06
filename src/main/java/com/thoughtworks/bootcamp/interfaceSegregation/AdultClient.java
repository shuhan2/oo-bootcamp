package com.thoughtworks.bootcamp.interfaceSegregation;

public class AdultClient implements HumanAble {

  @Override
  public String eat() {
    return "eat";
  }

  @Override
  public String drink() {
    return "drink";
  }

  @Override
  public String snore() {
    return "snore";
  }

}
