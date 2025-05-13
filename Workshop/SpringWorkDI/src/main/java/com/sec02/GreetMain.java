package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml");
      EveningGreet res = context.getBean("greeting",EveningGreet.class);
       System.out.println(res.greeting());
    }
}
