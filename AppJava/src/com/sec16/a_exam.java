package com.sec16;


// Runnable 인터페이스를 상속받아 두 개의 스레드를 생성해 실행
public class a_exam implements Runnable{
	
	@Override
	public void run() {
		for(int i=0;i<=200;i++) {
			System.out.println("스레드");
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("===========main start =========");
		Thread t1 = new Thread(new a_exam(),"야옹이");
		Thread t2 = new Thread(new a_exam(),"멍뭉이");
		t1.start(); // 메소드단위 실행 = run() 
		t2.start();
		
		System.out.println("===========main mid =========");
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException i) {
			System.out.println(i); // i.getStackTrace()
		}
		System.out.println("===========main end =========");
	}
}
