package com.thoughtworks.bootcamp.fizzBuzz;

public class FizzBuzz {

  public String convert(int number) {
    if (number % 3 == 0 && number % 5 == 0) {
      return "FizzBuzz";
    }
    if (number % 3 == 0) {
      return "Fizz";
    }
    return "Buzz";
  }
}
