package com.sec04;
import java.util.Scanner;

//한문자 입력받아 소문자이면 "소문자" 출력 , 대문자면 대문자, 숫자면 숫자 출력,
// 아무것도 아니면 이도저도 아님 출력 
public class IfTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("한문자를 입력하세요: ");
		char ch = sc.next().charAt(0);

		if (Character.isLowerCase(ch)) {
			System.out.println("ch=" + ch + " 소문자");
		} else if (Character.isUpperCase(ch)) {
			System.out.println("ch=" + ch + " 대문자");
		} else if (Character.isDigit(ch)) {
			System.out.println("ch=" + ch + " 숫자");
		} else {
			System.out.println("이도저도 아님");
		}
		
		char ch2 = sc.next().charAt(0);
		
		if(Character.isLowerCase(ch2)) {
			System.out.println("소문자");
			System.out.println("소문자 "+ch2+" 대문자로 변환 결과 : "+Character.toUpperCase(ch2));
		}else if(Character.isUpperCase(ch2)) {
			System.out.println("대문자");
			System.out.println("대문자 "+ch2+" 소문자로 변환 결과 : "+Character.toLowerCase(ch2));
		}else if(Character.isDigit(ch2)) {
			System.out.println("ch=" + ch + " 숫자");
		}else {
			System.out.println("이도저도 아님");
		}
	}
}


