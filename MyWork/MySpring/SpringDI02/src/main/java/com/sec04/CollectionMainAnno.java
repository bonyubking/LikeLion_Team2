package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class CollectionMainAnno {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("application04.xml");
		MyCollection myCollection = ctx.getBean("myCollection",MyCollection.class);
		
		myCollection.printItems();
		myCollection.printArray();
		myCollection.printSet();
		myCollection.printMap();
		myCollection.printMyaddr();
	
	}

}
