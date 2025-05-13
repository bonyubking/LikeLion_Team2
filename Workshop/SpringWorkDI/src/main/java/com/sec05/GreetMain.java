package com.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext05.xml");

    GreetManager greetManager = context.getBean("greetManager", GreetManager.class);
    greetManager.execute();
  }
}
