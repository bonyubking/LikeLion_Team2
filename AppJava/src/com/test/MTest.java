package com.test;

abstract class ABC{
	public abstract void prn();
	public abstract void disp();
}

class XX extends ABC{

	@Override
	public void prn() {
		System.out.println("XX prn");
		
	}

	@Override
	public void disp() {
		System.out.println("XX disp");
		
	}
	
}

class YY extends ABC{

	@Override
	public void prn() {
		System.out.println("YY prn");
		
	}

	@Override
	public void disp() {
		System.out.println("YY disp");
		
	}
	
}

public class MTest {
	public static void view(ABC obj){
		//하나의 부모타입을 통해 여러 자식 객체를 참조할 수 있도록 하는 개념
		//메소드를 오버라이딩해 실행 시점에서 객체의 실제 타입에 따라 적절한 메소드가 실행되도록 함 [동적바인딩]
		obj.disp();
		obj.prn();
	}
	public static void main(String[] args) {
		ABC a1 = new XX();
		ABC a2 = new YY();
		
		XX x1 = new XX();
		YY y1 = new YY();
		
	}

}
