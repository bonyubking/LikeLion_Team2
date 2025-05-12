package com.sec07.mytest03;

public class StaticTest {	
	public static int static_var = 0;
	private int non_static;
	
	public StaticTest() {
		non_static++;
		static_var++;
	}
	
	public int getNon_static() {
		return non_static;
	}

	public static void main(String[] args) {
		for (int i=0; i<=5; i++) {
			System.out.println(new StaticTest().getNon_static());
		}
		System.out.println(StaticTest.static_var);
	}
}
