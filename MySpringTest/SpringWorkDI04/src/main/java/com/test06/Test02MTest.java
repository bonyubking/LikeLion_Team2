package com.test06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {
	
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans06.xml");

        Student student = ctx.getBean("student", Student.class);
        student.calculate();

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}