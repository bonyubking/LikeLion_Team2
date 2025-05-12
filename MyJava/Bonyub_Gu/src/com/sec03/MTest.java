package com.sec03;

class Test {

	// 은닉된 멤버변수
	private int a;
	private int b;

	// setter -void
	public void setA(int a) {
		this.a = a; // 전달 및 변경 지역변수 a를 통해서 값을 전달 받아 this.a에 대입.
	}

	public void setB(int b) {
		this.b = b;
	}

	//getter

	public int getA() {
		return a; // this.a 현재 멤버 변수 값리턴
	}

	public int getB() {
		return b;// this.b
	}
}

public class MTest {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test m = new Test();
		Test m1 = new Test();
		Test m2 = new Test();
		t1.setA(100);
		t1.setB(200);

		System.out.println(t1.getA());
		System.out.println(t1.getB());
		
		System.out.println(m.toString()+ "\t"+ m);
		System.out.println(m.toString()+ "\t"+ m1);
		System.out.println(m.toString()+ "\t"+ m2);
		
		System.out.printf("m  a = %5d, b = %5d \n", m.getA(),m.getB());
		System.out.printf("m1  a = %5d, b = %5d \n", m1.getA(),m1.getB());
		System.out.printf("m2  a = %5d, b = %5d \n", m2.getA(),m2.getB());
	}
}