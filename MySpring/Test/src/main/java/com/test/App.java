package com.sec01;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MyAddress res = context.getBean("myAddress", MyAddress.class);
        System.out.println(res);
    }
}
