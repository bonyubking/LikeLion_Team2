package com.sec16;

// Thread 클래스를 상속받아 두 개의 스레드를 생성해 실행
public class a_exam02 extends Thread{
	
	public a_exam02(String thread_name) {
		super(thread_name); // Thread(String name) 
	}
	
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("스레드 : "+getName() + i);
			try {
				Thread.sleep(500); // static method 
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt(); // static method 
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new a_exam02("야옹이");
		Thread t2 = new a_exam02("멍뭉이");
		t1.start();
		t2.start();
	}
}
