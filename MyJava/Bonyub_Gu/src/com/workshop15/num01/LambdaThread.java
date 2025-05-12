package com.workshop15.num01;


// 람다로 스레드 생성하면서 이름 전달 예제
public class LambdaThread {

	public static void main(String[] args) {
		
		Thread t = new Thread(() -> {
							System.out.println("hello thread " + Thread.currentThread().getName());
		
		}, "my-work01"
		 );
		
		t.start();

		// 생성후 SetName 메서드 사용

		Thread t4 = new Thread (() -> {
				System.out.println("hello thread04" + Thread.currentThread().getName());
		});
		
		t4.setName("Thread 04 ");
		t4.start();
		
		
		
		// 5. 가상 스레드르 생성해서 이름을 지정하는 연습 
		
		var t05 = Thread.ofVirtual().name("vt-", 1).unstarted(() -> {
			System.out.println("hello thread04" + Thread.currentThread().getName());

		});
		
		t05.start();
		
		
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


