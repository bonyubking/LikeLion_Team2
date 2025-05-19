package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {
	
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans04.xml");

        Student student = ctx.getBean("student", Student.class);
        student.eat("라면");

        ((ClassPathXmlApplicationContext) ctx).close();
    }
}