package com.sec05.exam;

public class b_Array {

	public static void main(String[] args) {
		Test();

	}

	private static void Test() {
		
		// 동적할당
		int ar02[] = new int[10];
		
		Prn(ar02);
		
		for(int i=0; i<ar02.length; i++) {
			ar02[i] = i+1;
		}
		System.out.println(ar02);
		
		Prn(ar02);
		reversePrn(ar02);
	}
	
	public static void reversePrn(int[] ar) {
		//반복 FOR문 출력 (역순)
		for (int i= ar.length-1; i >= 0; i--) {
			System.out.println(ar[i]);
		}
	}
	
	
	
	public static void Prn(int[] ar) {
		//반복 FOR문 출력
		for (int i=1; i <= ar.length; i++) {
			System.out.println(ar[i-1]);
		}
	}
}