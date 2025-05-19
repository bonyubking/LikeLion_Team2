package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sec03.FruitService;

public class CollectionMain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application04.xml");
		MyCollection service = ctx.getBean("myCollection", MyCollection.class);
		service.printItems();
		
		service.printArray();
		
		service.printSet();
		
		service.printMap();
		
		service.printMyaddr();

	}

}
