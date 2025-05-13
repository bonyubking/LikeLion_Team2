package com.sec04;

public class GreetService {
  private final Greet greet;
  public GreetService(Greet greet){
    this.greet = greet;
  }
  public void sayHello(){
    System.out.println(greet.greeting());
  }

}
