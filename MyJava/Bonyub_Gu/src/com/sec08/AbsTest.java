package com.sec08;

abstract class My { // New My()
	public void prn() {
		System.out.println("나  추상의 멤버얌 My's Prn ");
	}
	public abstract void disp(); // {} 가 없는 선언만 되어있는 추상 메소드
}
class myTest extends My { // 추상 클래스를 상속 받은 후손클래스는 추상클래스의 추상 메소드를 반드시 정의해야한다.
							// 2. 재정의 하지 않으면 추상 클래스가 된다. -> new 객체 생성 불가
	public void disp() {
		System.out.println(" 그래 난 강제로 정의한 myTest's disp");
	}
}
public class AbsTest {
	public static void main(String[] args) {
		// My m=new My(); 
		myTest m = new myTest();
		m.prn();
		m.disp();
	}
}

