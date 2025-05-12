package com.workshop15.num05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualTest {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
		
		for (int i = 1; i <=5; i++) {
			
			int task = i;
					
			executor.submit(() -> {
				System.out.println("가상 스레드 " + task +"번 실행 중");
			    try {
                    Thread.sleep(500); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			});
		}
		
		executor.shutdown();
		
		
		// 모든 작업이 종료될떄까지 대기 isTerminated() > ExecutorService스레드풀에 전체 작업 종료되었는지 확인 메서드
		while(!executor.isTerminated()) {
			Thread.sleep(100);
		}
		System.out.println("main 종료");

	}

}
