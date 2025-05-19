package com.Person.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.Person.config.*;


public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonController controller = context.getBean(PersonController.class);
		
		controller.run();
		
		((AbstractApplicationContext) context).close();
	}

}
