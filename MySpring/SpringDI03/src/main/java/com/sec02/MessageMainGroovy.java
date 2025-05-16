package com.sec02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class MessageMainGroovy {

  public static void main(String[] args) {
    // .groovy 현재 버전에서 import 안됨
    ApplicationContext context = new GenericGroovyApplicationContext("app02.groovy","app02-2.groovy");
    MessagePrinter res = context.getBean("messagePrint", MessagePrinter.class);
    res.print();

    MessagePrinter res02 = context.getBean("messagePrint02", MessagePrinter.class);
    res02.print();

  }

}
