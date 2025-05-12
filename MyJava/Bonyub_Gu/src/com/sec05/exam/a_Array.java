package com.sec05.exam;

public class a_Array {

	public static void main(String[] args) {
		Test();
		
	}
	
	private static void Test() {
		int[] ar = {10, 20, 30, 40, 50};
		int ar02[] = {10, 20, 30, 40, 50};
		
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(ar[2]);
		System.out.println(ar[3]);
		System.out.println(ar[4]);
		
		//Case02. 반복 FOR문 출력
		
		for (int i=0; i<=4; i++) {
			System.out.println(ar[i]);
		}
		
		// Case03. 제네릭 for문 출력  
		
		for (int res : ar) {
			System.out.println(res);
		}
		
	}

}
