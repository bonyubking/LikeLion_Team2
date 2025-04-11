package com.test;

abstract class AA  {
	//new My() 객체 생성 안함 -> 후손이 클래스가 메모리 할당해달라는 뜻
	public void prn() {
		System.out.println("추상메서드 prn");
	}
	public abstract void disp(); //{}r가 없는 선언만 되어있는 추상메소드


}

public class myA extends AA{

	@Override
	public void disp() {
		// TODO Auto-generated method stub
		
	}

	
}