package com.workshop15.num06;

import java.util.concurrent.CompletableFuture;

public class AsyncCalcTest {

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
        	System.out.println("계산 결과 : " + result); 
        });
        
        
        
        

		System.out.println("main 종료");
		
		future.join();
		}

}


/*
생성
CompletableFuture
.supplyAsync(Supplier) 결과를 반환하는 비동기 작업 시작
. runAsync(Runnable)   결과 없이 실행하는 비동기 작업 

결과 후 처리 
thenApply(fn):    CompletableFuture<R>
thenAccept(Consumer):    CompletableFuture<Void>
thenRun(Runnable):    CompletableFuture<Void>



thenCombine(future2, (a,b) -> ...) : 두 개의 결과조합
thenAcceptBoth(future2, (a,b) -> ...) : 두 결과 실행 후 종료
runAfterBoth(f1, f2)    : 결과 없이 둘 다 끝난 후 작업


코드 예 ) 10 받아서 *2 결과를 비동기 스레드로 연산한다
COmpletableFuture.supplyAsync(() -> 10). thenApply( n->n*2).thenAccept(System.out::println)


1)Spring Boot     :REST 비동기 응답, 외부 API 호출 조합 처리
2)WebClient + Reactor 연동 : .toFuture() 변환 시 CompletableFuture 사용
3) 백엔드 계산 분리    AI, 이미지 처리 등 비동기 CPU 작업
4) 테스트/모의 비동기 시나리오: CompletableFuture.completedFuture(...) 자주 사용
https://docs.spring.io/spring-data/jpa/reference/repositories/query-return-types-reference.html#appendix.query.return.types
*/