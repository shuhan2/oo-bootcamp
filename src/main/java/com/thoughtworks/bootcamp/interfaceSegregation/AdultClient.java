package com.thoughtworks.bootcamp.interfaceSegregation;

public class AdultClient implements HumanAble, AdultAble {

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

  @Override
  public String report() {
    return "report";
  }

  @Override
  public String work() {
    return "work";
  }
}
