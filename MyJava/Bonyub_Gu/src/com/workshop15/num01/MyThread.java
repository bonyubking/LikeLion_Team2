package com.workshop15.num01;

public class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name);
	}
	
    @Override
    public void run() {
        System.out.println("스레드 실행 중");
    }
}