package com.sec16.appletree;

import java.util.concurrent.CompletableFuture;

// case 3: CompletableFuture 사용 -> 자바의 비동기 병렬처리의 핵심 클래스 
// 
/*
 * [Future와 Callable 결과 반환 ->Future, Callable<T>, get() -> 리턴값 있는 비동기]의 개선된 확장성 
 * 		Future의 단점 : 예외처리 어렵과 get() 결과를 기다릴때 블로킹함. 후 작업할 수 없음 => 잘 사용 안함 
 * 
 * CompletableFuture.supplyAsync().thenApply().thenAccept(System.out::println) 
 * 						비동기시작   연산          출력 
 * 
 * 동기화 : 작업이 끝날때까지 기다렸다가 다음 작업으로 넘어감 -> 전화받을때까지
 * 비동기화 : 작업을 요청한 다음, 결과를 기다리지 않고 다음 작업으로 넘어감 -> 문자메세지 
 * */

/*
 * pickApple("Cat") 호출됨
 * CompletableFuture.runAsync() 
 * 	새 스레드 생성되어 람다 블록 내용을 비동기적으로 실행할 준비
 * 	단, 실행 시점은 확정되지 않음 
 * try{Thread.sleep...}
 * 	비동기작업을 실행 요청만 해놓고 현재 스레드는 0~1ms  sleep
 *	현실감 부여용 
 *
 *[Main Thread] pickApple("Cat") 호출
 *[Main Thread] runAsync(...) → 비동기 작업 등록
 *[Main Thread] sleep 0~1ms
 *[Main Thread] return true (끝)

 *[Background Thread] → runAsync 블록 실행 시작
 *[Background Thread] synchronized 진입
 *[Background Thread] apples > 0 이면 사과 따고 출력
 * 
 * */
public class AppleTreeCase4_Async extends AppleTreeCompetition {
    protected boolean pickApple(String who) {
        CompletableFuture.runAsync(() -> { // 람다 작업을 새 스레드에서 비동기적으로 실행됨
        	// pickApple 메서드를 호출한 메인스레드는 사과 따는 일을 기다리지 않고 다음 작업으로 넘어감 
            synchronized (this) {
            	// 여러 스레드가 apples -- 하고 있으면 오류 발생하므로 동기화해줌 
            	//this 객체를 기준으로 잠금 걸고 하나씩 순차적으로 작업하게 해줌 
                if (apples <= 0) return;
                apples--;
                if (who.equals("Cat")) catCount++;
                else dogCount++;
                System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            }
        });
        // 메소드 호출 후 짧은 랜덤 대기. 사과따는 작업이랑 상관없고 호출자 입장에서 기다리는 용도 
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}