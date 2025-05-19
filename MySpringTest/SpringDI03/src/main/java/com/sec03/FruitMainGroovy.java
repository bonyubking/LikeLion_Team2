package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import com.sec02.MessagePrinter;

public class FruitMainGroovy {

	public static void main(String[] args) {
		
		GenericGroovyApplicationContext context =
				new GenericGroovyApplicationContext("app03.groovy");		
		
		
		FruitService service = context.getBean("fruitService", FruitService.class);
		service.printName();

	}

}
