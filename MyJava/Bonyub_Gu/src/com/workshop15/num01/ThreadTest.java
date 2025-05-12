package com.workshop15.num01;

public class ThreadTest {
    public static void main(String[] args) {

        MyThread t1 = new MyThread("1번스레드");
        MyThread t2 = new MyThread("2번스레드");

        t1.start();  // 첫 번째 스레드 실행
        t2.start();  // 두 번째 스레드 실행
        
        try {
			t1.join();
	        t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


        System.out.println("main 종료");
    }
}

