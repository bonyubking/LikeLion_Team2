package com.sec01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnnoMain {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    MyAddress res = context.getBean("myAddress",MyAddress.class);
    System.out.println(res);

    AddressInfo info = context.getBean("info",AddressInfo.class);
    info.prn();
  }
}
