package com.sec01.exam;

public class f_exam {
	
	public static void prn01(long res) { 
		//메소드 호출할 때 정수값 받으면서 지역변수 생성해 값대입 함  
		System.out.println("정수 res ="+res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prn01(1);
		prn01('a');
		prn01((long)90.1);
	}

}
