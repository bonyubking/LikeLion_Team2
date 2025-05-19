package com.test09;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements Person2 {
	
	public Student() {
	}
	

	@LogExecution
	@Override
	public void submit() {
		
		System.out.println("[Student] 제출 중...");
	}
	

}
