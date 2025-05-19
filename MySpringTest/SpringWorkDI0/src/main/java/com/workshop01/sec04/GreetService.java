package com.workshop01.sec04;
import com.workshop01.sec04.Greet;

public class GreetService {
    private final Greet greet;


    public GreetService(Greet greet) {
        this.greet = greet;
    }

    public void sayHello() {
        System.out.println(greet.greeting());
    }
}