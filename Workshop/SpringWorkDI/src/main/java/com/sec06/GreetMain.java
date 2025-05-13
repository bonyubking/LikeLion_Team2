package com.sec06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class GreetMain {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext("applicationContext06.xml");
    GreetService greetService = context.getBean("greetService",GreetService.class);
    greetService.sayHello();


  }
}
