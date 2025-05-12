package com.workshop3;
import java.util.Scanner;
//1부터 100까지 더하는 프로그램 작성, 1자리 정수형 Scanner로 입력받아 받은 수의 배수만!
public class Test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int i = input;
		int ans = 0;
		
		while (i<=100) {
			
			ans += i;
			System.out.printf("%d",i);

			
			if(i+input<=100) {
				
				System.out.printf("+");
			}
			
			i += input;
		}
		
		System.out.printf("="+ans);

	}

}
