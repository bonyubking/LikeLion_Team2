package com.test;
//static final, abstract, default, static
public class IAA {
	
	
	int a = 10;
	public static final int b = 20;
	void prn();
	
	public abstract void disp();
	
	default void view() {
		System.out.println(a);
	}
	
	static void view02{
		System.out.println(a);
	}
}
