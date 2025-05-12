package com.sec02.exam;

public class a_exam {

	public static void main(String[] args) {

		int a = 100;
		
		System.out.println("2진법 " + Integer.toBinaryString(a));
		
		String res = Integer.toBinaryString(a);
		System.out.println("2진법 " + res);
		
		System.out.println("8진법 " + Integer.toOctalString(a));
		
		System.out.println("16진법 " + Integer.toHexString(a));
		
		System.out.println("int의 범위는 " + Integer.MIN_VALUE + "~~~" + Integer.MAX_VALUE);

	}

}
