package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import com.sec03.FruitService;

public class CollectionMainGroovy {

	public static void main(String[] args) {
		
		GenericGroovyApplicationContext context =
				new GenericGroovyApplicationContext("app04.groovy");		
		
		
		MyCollection service = context.getBean("myCollection", MyCollection.class);
		service.printItems();
		
		service.printArray();
		
		service.printSet();
		
		service.printMap();
		
		service.printMyaddr();

	}

}
