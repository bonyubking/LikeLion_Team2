package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnoMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		MyAddress res = context.getBean("myaddress", MyAddress.class);
		System.out.println(res);

		AddressInfo res02 = context.getBean("info", AddressInfo.class);
		System.out.println(res02);
		res02.prn();
	}
}

		
/*
		AddressInfo res02 = context.getBean("info", AddressInfo.class);
		context.getBean("myaddress",Myaddress.class); 
		System.out.println(res02);
		res02.prn(); */
	

