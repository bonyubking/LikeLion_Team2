package com.sec03;

public class MyClass {
	
	private int a;

	public MyClass() {}
	public MyClass(int a) {
		this.a = a;
		System.out.println("오버로드 생성");
	}
	
	public static void main(String [] args) {
		MyClass m1 = new MyClass(200);
		System.out.println(m1);

	}
	

}
