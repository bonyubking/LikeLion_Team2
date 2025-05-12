package com.workshop6;

public class Calc {
	
	public void calculate(int data) {
		int sum = 0;
		
		System.out.printf("짝수:");
		for (int i=2; i<= data; i+=2) {
			sum += i;
			System.out.printf("%d ", i);
		}
		
		System.out.println();
		System.out.printf("결과:%d",sum);
	}
	
}
