package com.sec02;
public class IncDecOperator {
	public static void main(String[] args) {

		int op = 10; 

		System.out.println(op++); //10읊 리턴한 후 출력되고, 11 됨
		System.out.println(op); //11

		System.out.println(++op); //11을 1 증가한 후 12를 리턴해서 출력됨
		System.out.println(op); //12

		System.out.println(op--); //12를 리턴하고 11이됨
		System.out.println(op); //11

		System.out.println(--op); //10리턴
		System.out.println(op); //10

	}
}




