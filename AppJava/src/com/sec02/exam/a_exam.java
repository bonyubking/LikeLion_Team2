package com.sec02.exam;

public class a_exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer 클래스를 이용해 다양한 기능을 호출하기
		
		int a = 100;
		
		//2진수 문자열 출력
		System.out.print("2진으로 "+Integer.toBinaryString(a)+"\n");
		//8진수 문자열 출력
		System.out.print("8진으로 "+Integer.toOctalString(a)+"\n");
		//16진수 문자열 출력
		System.out.print("8진으로 "+Integer.toHexString(a)+"\n");
		
		System.out.print("int의 범위는 "+Integer.MIN_VALUE +"~~~"+Integer.MAX_VALUE+"\n");
		System.out.print("double의 범위는 "+Double.MIN_VALUE +"~~~"+Double.MAX_VALUE+"\n");


	}

}
