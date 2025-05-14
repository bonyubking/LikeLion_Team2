package com.sec04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionMain {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application04.xml");
    MyCollection myCollection = context.getBean("myCollection", MyCollection.class);
    myCollection.printItems();
    myCollection.printArray();
    myCollection.printSet();
    myCollection.printMap();
    System.out.println("================================================");
    myCollection.printAddr();
  }

}
