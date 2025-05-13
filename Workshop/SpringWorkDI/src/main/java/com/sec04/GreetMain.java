package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext04.xml");

    GreetService greetService = context.getBean("greetService", GreetService.class);
    greetService.sayHello();
  }
}
