package com.sec03;

import java.util.Random;
import java.util.Scanner;

public class MTest02 {

	public static void main(String[] args) {
		Integer i = 100;
		System.out.println(i.doubleValue());
		Integer i2 = new Integer("100");
		System.out.println(i2.doubleValue());
		
		String str = "abcdefg"; //String str = new String("abcdefg")와 같음
		System.out.println("길이 ="+str.length());
		System.out.println("전체 대문자 = "+str.toUpperCase());
		
		String res = str.toUpperCase();
		System.out.println("출력 :"+res+" ->소문자로 : "+res.toLowerCase());
		
		//Random 클래스
		//java.util.Random클래스가 있다, 빈 객체를 생성하고 0~100까지 난수 생성하는 메소드 호출해 출력
		//1. 생성자 확인 -> 2. nextInt(int) 활용 ->
		
		Random rand = new Random();
		rand.setSeed(1);
		System.out.println(rand);
		int num = rand.nextInt(101);
		System.out.println(num);
		
		int r3 = (int)(Math.random() * 101);
	}

}
