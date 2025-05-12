package com.test;


abstract class ABC{
	
	public abstract void prn();
	public abstract void disp();
}

class XX extends ABC{

	@Override
	public void prn() {
		System.out.println("XX' prn ");
	}

	@Override
	public void disp() {
		System.out.println("XX' disp ");
		
	}
	
	
}

class YY extends ABC{
	
	@Override
	public void prn() {
		System.out.println("YY' prn ");
	}

	@Override
	public void disp() {
		System.out.println("YY' disp ");
		
	}
	
}

public class MTest {
	
	
	public static void view(ABC obj) {
		
		//하나의 부모타입을 통해 여러 자식객체 참조
		// 메소드를 오버라이딩해서 실행 시점에서 객체의 실제 타입에 따라 적절한 메소드가 실행되도록.
		// -> 화살표 == (: return) 두개 붙여놓은거랑 같은효과
		switch(obj) {
		case XX xx-> {
					xx.disp();
					xx.prn();
		}
		case YY yy-> {
					yy.disp();
					yy.prn();
		}
		
		default -> System.out.println("알 수없는 타입");
		
		}
		
}

	public static void main(String[] args) {
		
		ABC a1 = new XX();
		ABC a2 = new YY();
		
		XX x1 = new XX();
		YY y1 = new YY();

	}

}
