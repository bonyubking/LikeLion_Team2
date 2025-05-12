package com.sec01.exam;

public class g_exam {
	
	public static void prn01(long res) {
		System.out.println("정수 res =" + res);
		
	}
	
	public static void prn02(char res) {
		System.out.println("정수 res =" + res);
		
	}
	
	public static void prn03(double res, int a) {
		System.out.println("실수 res =" + res + "정수 a= " + a);
		
	}
	
	public static void main(String[] args) {
		
		prn01(100);
		prn01('a');
		prn01((long)90.1);
		prn03(100, 100);
		
	}

}
