package com.test03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;


public class MainApp { 
    public static void main(String[] args) { 
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext 
        			("classpath:application.groovy"); 
        OrderService service = context.getBean("orderService", OrderService.class); 
        System.out.println(service.order(1, 10000)); 
    } 
} 

