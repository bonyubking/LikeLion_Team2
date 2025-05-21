package com.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application05.xml");
		AddressRecord res = (AddressRecord) context.getBean("myaddress01");
		System.out.println(res);
  }
}