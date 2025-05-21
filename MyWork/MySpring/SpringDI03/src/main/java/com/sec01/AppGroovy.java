package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class AppGroovy {
	public static void main(String[] args) {
		ApplicationContext context = new GenericGroovyApplicationContext("app01.groovy");
		MyAddress res = (MyAddress) context.getBean("myaddress");
		System.out.println(res);
		System.out.println(res.toString());

		MyAddress res02 = context.getBean("myaddress02", MyAddress.class);
		System.out.println(res02);

		AddressInfo info = context.getBean("info", AddressInfo.class);
		info.prn();
	}
}
