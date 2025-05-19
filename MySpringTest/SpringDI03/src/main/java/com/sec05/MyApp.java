package com.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application05.xml");

        // Bean ID는 my01 또는 my02 중 하나로 수정
        AddressRecord ar = context.getBean("my01", AddressRecord.class);

        // 변수명 ar로 출력하도록 수정
        System.out.println(ar);
        System.out.println(ar.toString());
    }
}