package com.sec04.exam;

public class WhileTest01 {

	public static void main(String[] args) {
		int i = 1;
		int evensum = 0;
		int oddsum = 0;
		
		while (i <= 100) {
			if ((i % 2) == 0 ) {
				evensum += i;
			}else {
					oddsum+= i;
				}
			i++;
			}
		System.out.println("짝수합 : " + evensum);
		System.out.println("홀수합 : " + oddsum);
		}

	}


