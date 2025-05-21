package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application01.xml");
		MyAddress res = (MyAddress) context.getBean("myaddress");
		System.out.println(res);
		System.out.println(res.toString());

		MyAddress res02 = context.getBean("myaddress02", MyAddress.class);
		System.out.println(res02);

		AddressInfo info = context.getBean("info", AddressInfo.class);
		info.prn();
	}
}
