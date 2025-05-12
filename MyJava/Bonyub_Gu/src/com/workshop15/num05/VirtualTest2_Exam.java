package com.workshop15.num05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualTest2_Exam {

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
		
		if(executor.awaitTermination(3, TimeUnit.SECONDS)) {
			
			System.out.println("작업 종료");
		}
		else {
			System.out.println("아직 종료 안됨 ");
		}
		
		// 모든 작업이 종료될떄까지 대기 isTerminated() > ExecutorService스레드풀에 전체 작업 종료되었는지 확인 메서드
			
		System.out.println("main 종료");

	}

}
