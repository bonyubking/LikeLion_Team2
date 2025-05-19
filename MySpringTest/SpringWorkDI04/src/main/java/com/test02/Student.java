package com.test02;

import org.springframework.stereotype.Component;

@Component("student")
public class Student implements Person{
	public void getScore() {

			System.out.println("[Student] 점수 조회 중 ..");

	}
}
