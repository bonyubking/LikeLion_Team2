package com.workshop15.num07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolExample {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> { // 비동기 작업 수행
                System.out.println("작업 " + taskId + " 처리 중");
            });
        }

        executor.shutdown(); // 작업 제출 종료

	}

}
