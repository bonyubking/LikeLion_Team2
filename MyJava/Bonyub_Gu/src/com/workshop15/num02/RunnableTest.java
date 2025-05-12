package com.workshop15.num02;

public class RunnableTest {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnable());
		Thread t2 = new Thread(new MyRunnable());
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
