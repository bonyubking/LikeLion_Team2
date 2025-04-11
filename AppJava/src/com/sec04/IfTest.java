package com.sec04;
import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
		//정수 하나를 입력해서 입력한 수가 0보다 크면 양수라고 출력하자
		Scanner sc = new Scanner(System.in);
		int su;
		System.out.print("정수입력 : ");
		su = sc.nextInt();
		if (su > 0) {//{}가 없으면 한 줄만 영역으로 간주함. 
			System.out.println("양수 ");
		}
		sc.close();
			
	}
}







