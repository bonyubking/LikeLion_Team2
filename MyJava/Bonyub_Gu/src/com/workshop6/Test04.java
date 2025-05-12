package com.workshop6;
import java.util.Random;

public class Test04 {

	public static void main(String[] args) {
		
		
		int errnum = args.length;
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int len = num1+num2;
		
		if (errnum != 2) {
			System.out.println("다시 입력 하세요");
		}
		
		else {
			

			
			if (num1<1 || num1>5 || num2<1 || num2>5) {
				System.out.println("숫자를 확인 하세요");
			}
		} 
		
		int [][] arr = new int[num1][num2];
		float sum = 0;
		Random rand = new Random();
		
		for (int i=0; i<num1; i++) {
			for(int j=0; j<num2; j++) {
				arr[i][j] = rand.nextInt(5)+1;
				sum += (float)arr[i][j];
				System.out.printf("%d ", arr[i][j]);
				}
			System.out.println();
		}
		
		System.out.println("sum= "+sum);
		System.out.println("avg= "+sum/(float)len);
		
	}

}
