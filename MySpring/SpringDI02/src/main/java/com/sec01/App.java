package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        MyAddress res01 = context.getBean("myAddress", MyAddress.class);
        System.out.println(res01);

        MyAddress res02 = context.getBean("myAddress02", MyAddress.class);
        System.out.println(res02);

        AddressInfo res03 = context.getBean("info", AddressInfo.class);
        System.out.println(res03);
        res03.prn();
    }
}
