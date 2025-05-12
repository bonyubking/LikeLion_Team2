package com.workshop15.num10;

import java.util.concurrent.CompletableFuture;

public class FutureExample {

	public static void main(String[] args)  { 
		
		//① 비동기 계산 시작 (200 + 100)
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            int a = 100;
            int b = 200;
            return a + b;
        });
        
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        future.thenAccept(result -> {
        	System.out.println("최초 계산 결과 : " + result); 
        });
        
        
        CompletableFuture<Integer> finalResult = future.thenApply(result -> result * 2);

        finalResult.thenAccept(result -> System.out.println("후속 계산 결과(x2) : " + result));
        
        
        

		System.out.println("main 종료");
		
		future.join();
		}

}
