package com.sec01;

public class DataType {
	//전역변수 영역 = 멤버 필드 영
	public static void prn() {
		boolean result = true; 
		//result라는 이름의 변수를 선언하고 true 값을 대입
		result = false;
		
		System.out.println("result =" + result);
	}
	public static void main(String[] args) {
		//지역변수 영역
		prn();
		
	}
}
