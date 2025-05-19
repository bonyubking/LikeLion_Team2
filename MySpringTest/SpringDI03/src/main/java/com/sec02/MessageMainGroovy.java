package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MessageMainGroovy {

	public static void main(String[] args) {
		
		GenericGroovyApplicationContext context =
				new GenericGroovyApplicationContext("app02.groovy", "app02-2.groovy");
		
		MessagePrinter res = context.getBean("messagePrint", MessagePrinter.class);
		res.print();
		
		MessagePrinter res2 = context.getBean("messagePrint02", MessagePrinter.class);
		res2.print();
	}

}
