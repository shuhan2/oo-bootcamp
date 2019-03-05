package com.thoughtworks.bootcamp.interfaceSegregation;

public class BabyClient implements HumanAble {

  @Override
  public String crawl() {
    return "crawl";
  }

  @Override
  public String eat() {
    return "eat";
  }
}
