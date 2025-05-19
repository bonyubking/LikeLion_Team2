package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05MTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans07.xml");
		

		System.out.println("======================================");
		Student student = context.getBean("student", Student.class);

		System.out.println("**** 학생 수업시작 ****");

		student.relax();
		student.homeWork();
		student.classWork();

		
		
		((ClassPathXmlApplicationContext) context).close();

	}

}
