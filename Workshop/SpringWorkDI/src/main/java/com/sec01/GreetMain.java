package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
       ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext01.xml");
       MorningGreet res = context.getBean("greeting",MorningGreet.class);
       System.out.println(res.greeting());
    }
}
