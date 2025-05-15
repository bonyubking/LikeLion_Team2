package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class AppGroovy {

  public static void main(String[] args) {
    ApplicationContext context = new GenericGroovyApplicationContext("app01.groovy");
    MyAddress res01 = context.getBean("myAddress", MyAddress.class);
    System.out.println(res01);
    AddressInfo info = context.getBean("info", AddressInfo.class);
    info.prn();
  }

}
