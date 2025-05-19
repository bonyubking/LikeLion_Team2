package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans01.xml");

		System.out.println("======================================");
		Person student = (Person) context.getBean("student",Person.class);

		student.classWork();
	}

}
