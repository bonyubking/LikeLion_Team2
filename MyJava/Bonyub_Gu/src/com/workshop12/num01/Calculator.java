package com.workshop12.num01;

public class Calculator {
	
	public static double plus(int a, int b) {
		return a+b;
	}
	
	public static double minus(int a, int b) {
		return a-b;
	}
	
	public static double divide(int a, int b) {
		
		if (b == 0) {
            throw new IllegalArgumentException("Exception이 발생하였습니다 다시 입력해 주세요.");}
		
		return (double) (a/b);
	}
	
	public static double multiplication(int a, int b) {
		return a*b;
	}

}
