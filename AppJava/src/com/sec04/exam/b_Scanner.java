package com.sec04.exam;

import java.util.Scanner; 

/*
 * 콘솔로 값을 입력 받는 방법
 * 
 * java.util.Scanner -> 타입의 입력이 메소드로 정해 있다
 * java.io.BufferedReader -> 문자열입력 특화/예외처리
 * java.lang.System.in.read() -> 한글자 특화
 * */


public class b_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요");
		String name = sc.nextLine();
		
		System.out.print("주소를 입력하세요");
		String addr = sc.nextLine();
		
		System.out.print("전화번호를 입력하세요");
		String tel = sc.nextLine();
		
		System.out.printf("%10s %10s %10s \n", name, addr, tel);
		
	}

}
