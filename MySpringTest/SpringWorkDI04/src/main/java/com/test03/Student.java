package com.test03;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements Person{
	public void homework() {

			System.out.println("[Student] 과제 수행 중..");
	        throw new RuntimeException();

	}
}
