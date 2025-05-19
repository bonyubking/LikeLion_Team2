package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02MTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans03.xml");

		System.out.println("======================================");
		Person student = (Person) context.getBean("student",Person.class);

		try {
			student.homework();
		} catch (Exception e) {
			
		}
	}

}
