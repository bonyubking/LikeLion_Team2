package com.sec02.exam;

public class b_exam {
	
	public void prn() {
		System.out.println("b_exam`prn -> non-static ");
		
	}

	public static void main(String[] args) {
		b_exam m = new b_exam(); // new 연산자를 만나면 객체를 동적 할당 = 클래스 객체를 생성 한다.
		
		
		System.out.println(m.toString());
		System.out.println(m);
		m.prn();
		
		
		b_exam m2 = new b_exam();
		System.out.println(m2.toString());
		System.out.println(m2);
		m2.prn();

	}

}
