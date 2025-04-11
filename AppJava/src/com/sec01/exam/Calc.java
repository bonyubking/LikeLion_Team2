package com.sec01.exam;

//두 수를 입력받아 사칙연산한 결과를 각각의 메소드로 리턴하는 클래
public class Calc {
	
	public static int getSum(int a,int b) {
		return a+b;
	}
	
	public static int getSub(int a,int b) {
		return b-a;
	}

	
	public static int getMul(int a,int b) {
		return a*b;
	}

	
	public static double getDiv(int a,int b) {
		return b/a;
	}
	
	public void nonStatic() {
		System.out.println("non-static메소드입니다.");
	}


}
