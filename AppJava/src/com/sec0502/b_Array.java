package com.sec0502;

public class b_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test();

	}
	public static void Test() {
		//1) 배열선언 생성 출력 확인 
		// 나열형 값을 선언과 동시에 대입 
		int[] ar = {10,20,30,40,50};
		int ar02[] =  {10,20,30,40,50,60,70,80,90};
		System.out.println("===ar출력===");
		Prn(ar02);
		System.out.println(ar02[0]);
	}
	
	public static void Prn(int[]ar) {
		System.out.println("===반복 for문 출력===");
		ar[0]=1000;
		for(int i=0;i<ar.length;i++) {
			System.out.printf("%5d",ar[i]);
		}
	}
}
