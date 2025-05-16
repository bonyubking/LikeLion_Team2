package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class FruitMainGroovy {
  public static void main(String[] args) {
    ApplicationContext context = new GenericGroovyApplicationContext("app03.groovy");
    FruitService fruitService = context.getBean("fruitService",FruitService.class);
    fruitService.printName();
  }

}
