package com.sec08;

abstract class My  {
	//new My() 객체 생성 안함 -> 후손이 클래스가 메모리 할당해달라는 뜻
	public void prn() {
		System.out.println("추상메서드 prn");
	}
	public abstract void disp(); //{}r가 없는 선언만 되어있는 추상메소드


}

class myTest extends My{
	//1. 추상 클래스를 상속 받은 후손 클래스는 추상 클래스의 추상메소드를 반드시 정의해야함
	//2. 재정의하지 않으면 추상클래스가 됨 -> new 객체 생성 불가능
	
	@Override
	public void disp() {
		System.out.println("MyTest에서 강제로 정의한 AA의 disp.");
		
	}
}
public class AbsTest {
	public static void main(String[] args) {
		// My m=new My(); 
		myTest m = new myTest();
		m.prn();
		m.disp();
		
		My res = new myTest();
		res.disp();
		res.prn();
	}
}

