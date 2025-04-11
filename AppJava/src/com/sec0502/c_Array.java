package com.sec0502;

public class c_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test();

	}
	public static void Test() {
		//1) 배열선언 생성 출력 확인 
		//동적 할당
		//배열 할당 시 각 공간은 자유 영역 여러 곳에 생성됨 
		int[] ar02 = new int[10];
		
		//2) 배열의 주소를 넘겨서 메소드에서 출력
		Prn(ar02);
		
		//3) 값 채움 
		for(int i=1;i<ar02.length;i++) {
			ar02[i] = i+1;
		}
		
		
		//4) 값 출력
		Prn(ar02);
		
		//5)역순으로 출력
		reversePrn(ar02);
	}
	
	public static void Prn(int[]ar) {
		System.out.println("===반복 for문 출력===");
		ar[0]=1000;
		for(int i=0;i<ar.length;i++) {
			System.out.printf("%5d",ar[i]);
		}
	}
	
	public static void reversePrn(int[]ar) {
		System.out.println("===반복 for문 역순으로 출력===");
		for(int i=ar.length-1;i>=0;i--) {
			System.out.printf("%5d",ar[i]);
		}
	}
}
