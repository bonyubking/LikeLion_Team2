package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext02.xml");
    Greet res = context.getBean("greeting", Greet.class);
    System.out.println(res.greeting());

    if(context.containsBean("greeting")){
      EveningGreet greet = context.getBean("greeting", EveningGreet.class);
      greet.doJob();
    }

    Greet res2 = context.getBean("lunchGreet",Greet.class);
    System.out.println(res2.greeting());

    if(context.containsBean("lunchGreet")){
      LunchGreet greet = context.getBean("lunchGreet",LunchGreet.class);
      greet.doJob();
    }



    ((AbstractApplicationContext)context).close();



  }
}
