package com.workshop01.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.workshop01.sec01.MorningGreet;

public class GreetMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EveningGreet res = context.getBean("eveningGreet", EveningGreet.class);
		System.out.println(res.greeting());

	}

}
