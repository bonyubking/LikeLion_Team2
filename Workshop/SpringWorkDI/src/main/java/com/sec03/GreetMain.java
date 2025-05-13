package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext03.xml");

    GreetService greetService = context.getBean("greeting", GreetService.class);
    greetService.sayHello();
  }
}
