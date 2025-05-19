package com.sec03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext03.xml");
        GreetService svc = ctx.getBean("greetService", GreetService.class);
        GreetService svc2 = ctx.getBean("greetService", GreetService.class);

        
        svc.sayHello();
        
        System.out.println(svc);
        System.out.println(svc2);
        
        System.out.println(System.identityHashCode(svc));
        System.out.println(System.identityHashCode(svc2));
    }
}
