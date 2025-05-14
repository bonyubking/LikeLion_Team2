package com.sec05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AddressMain {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application05.xml");
    AddressRecord addressRecord = context.getBean("myaddress01",AddressRecord.class);
    System.out.println(addressRecord);
  }

}
