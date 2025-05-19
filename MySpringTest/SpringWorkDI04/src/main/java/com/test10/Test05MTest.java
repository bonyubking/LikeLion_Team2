package com.test10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05MTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans10.xml");
		

		System.out.println("======================================");
		Student student = context.getBean("mystudent", Student.class);


		student.anything();
		
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
