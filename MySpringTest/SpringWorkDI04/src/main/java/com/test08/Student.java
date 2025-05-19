package com.test08;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements Person2 {
	
	public Student() {
	}
	
	@Override
	public void study() {
		
		System.out.println("[학생] 수업 중...");
	}
	

}
