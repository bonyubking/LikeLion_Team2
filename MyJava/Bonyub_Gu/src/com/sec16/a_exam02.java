package com.sec16;

public class a_exam02 extends Thread{
	
	public a_exam02(String thread_name) {
		
		super(thread_name);
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 50; i++) {
		System.out.println("나 쓰례드야 !! --> 내 이름은 " + getName()+ i);}
	}

	public static void main(String[] args) {
		
		
		a_exam02 t1 = new a_exam02("야옹");
		a_exam02 t2 = new a_exam02("멍멍");
		t1.setPriority(9);
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		t1.start();
		t2.start();
		
	}

	

}
