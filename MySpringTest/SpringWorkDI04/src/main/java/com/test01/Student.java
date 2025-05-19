package com.test01;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements Person{
	public void classWork() {

			System.out.println("[Student] 공부하는 중입니다.");

	}
}
