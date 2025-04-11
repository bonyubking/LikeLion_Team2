package com.sec04.exam;

public class a_IfTest {

	public static void main(String[] args) {
		//ex) 만일에 a가 0보다 크면 "양수" 출력
		int a = 100;
		if(a>0) {//결과가 true 명령을 수행함
			System.out.println("\"양수\" : "+a);
		}
		
		//만일에 a가 0보다 크면 "양수" 출력, 그렇지 않으면 "아니다" 출력
		
		if(a>0) {
			System.out.println(a);
		}else {
			System.out.println("아니다");
		}
		
		System.out.println("================");
		int num=10;
		if(num>0) {
			System.out.println("양수");
		}else if(num<0) {
			System.out.println("음수");
		}else {
			System.out.println("0입니다");
		}

	}

}
