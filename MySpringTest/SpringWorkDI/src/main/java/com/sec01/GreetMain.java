package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext01.xml");
        Greet greet = (Greet) ctx.getBean("morningGreet");
        System.out.println(greet.greeting());
        
        if (ctx instanceof ConfigurableApplicationContext) {
        	
        	((ConfigurableApplicationContext) ctx).close();
        }
        
        if (ctx instanceof ConfigurableApplicationContext) {
        	
        	boolean isActive = ((ConfigurableApplicationContext) ctx).isActive();
        	System.out.println(isActive);
        }
        
        try {
        	greet = ctx.getBean("morningGreet", Greet.class);
        	System.out.println(greet.greeting());
        } catch (IllegalStateException i) {
        	System.out.println("not initialized");
        }
    }
}