package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FruitMain {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    FruitService fruitService = context.getBean("fruitService",FruitService.class);
    fruitService.printName();
  }

}
