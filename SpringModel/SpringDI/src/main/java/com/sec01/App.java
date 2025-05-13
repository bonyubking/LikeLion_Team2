package com.sec01;


import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application01.xml");
		MyAddress res = (MyAddress)context.getBean("myaddress");  // context.getEam("myadress", Myaddress.class);
		System.out.println(res.toString());

		res = context.getBean("myaddress02", MyAddress.class);  // context.getBean("myaddress", Myaddress.class);
		System.out.println(res.toString());
	}

}
