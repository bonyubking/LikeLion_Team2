package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;


public class CollectionMainGroovy {
	public static void main(String[] args) {
		GenericGroovyApplicationContext ctx=new GenericGroovyApplicationContext("app04.groovy");
		MyCollection myCollection = ctx.getBean("myCollection",MyCollection.class);
		
		myCollection.printItems();
		myCollection.printArray();
		myCollection.printSet();
		myCollection.printMap();
		myCollection.printMyaddr();
	
	}

}
