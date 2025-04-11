package com.test;

//static final, abstract 메소드, default, static 메소드
// interface -> 생성자 없음 new 할 수 없음 다중 구현함 
public interface IAA {
	int a = 10; //반드시 초기값 설정 필요 
	public abstract void disp();
	default void view() { //재정의 능
		System.out.println(a);
	}
	static void view02() {
		System.out.println(a);
	}
}
