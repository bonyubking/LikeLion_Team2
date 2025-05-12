package com.workshop1;

class Test03 {
	public static void main(String[] args) {

		int num = 45728;

		int result = ((num / 1000) << 10) - (num/1000 * 24);
		
		System.out.println("기존 숫자: " + num);
		System.out.println("비트 연산 후 변환된 숫자: " + result);
	}
}
