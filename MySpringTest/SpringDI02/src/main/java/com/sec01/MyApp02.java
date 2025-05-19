package com.sec01;

import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MyApp02 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MyAddress res = (MyAddress) context.getBean("myaddress");
		System.out.println(res);
		System.out.println(res.toString());
		
		res = context.getBean("myaddress02", MyAddress.class);
		System.out.println(res);
		System.out.println(res.toString());
		
		res = context.getBean("myaddress03", MyAddress.class);
		System.out.println(res);
		System.out.println(res.toString());
		
		AddressInfo res02 = context.getBean("info", AddressInfo.class);
		res02.prn();

	}
}
