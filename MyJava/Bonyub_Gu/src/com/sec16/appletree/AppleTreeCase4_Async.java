package com.sec16.appletree;



//case 3 : CompletableFuture 사용 --> 비동기 병렬처리의 핵심 클래스
// [Future와 CAllable의 결과반환 -> Future,Callable<T> -> 리턴값 있는 비동기] 의 개선된 확장형

// Future의 단점 : 예외 처리가 어렵다 / get() 결과를 기다릴때 블록킹 /  후 작업을 할 수 없다.

// CompletableFuture.supplyAsync().thenAPply().thenAccept(System.out::println)
// 				비동기 시작 연산 출력

// 동기화 : 작업이 끝날때 까지 기다렸다가 다음 작업으로 넝ㅁ어간다
// 비동기화 : 작업을 요청한 다음, 결과를 기다리지 않고 바로 다음 작업으로 넘어간다

import java.util.concurrent.CompletableFuture;

public class AppleTreeCase4_Async extends AppleTreeCompetition {
    protected boolean pickApple(String who) {
        CompletableFuture.runAsync(() -> {
            synchronized (this) {
                if (apples <= 0) return;
                apples--;
                if (who.equals("Cat")) catCount++;
                else dogCount++;
                System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            }
        });
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}