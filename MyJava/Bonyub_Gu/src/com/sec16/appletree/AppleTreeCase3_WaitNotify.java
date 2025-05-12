package com.sec16.appletree;

//Case 2 .Object -> wiat(); /notifyALl(); -> synchronize 블럭 안에서만 호출 가능!
// ThreadPool을 대기했다가 다시 실행하도록 만듦.

/* synchronized (obj) P
 * 				while(!조건){
 * 						obj.wait(); / 스레드 일시 정지 + 락 반환
 * }
 * 			// 조건이 만족된 후 수행할 작업
 * }
 */

public class AppleTreeCase3_WaitNotify extends AppleTreeCompetition {
    private final Object lock = new Object();

    protected boolean pickApple(String who) {
        synchronized (lock) {
            while (apples <= 0) {
                try {
                    lock.wait(); //대기풀에서 번호 줌
                    return false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false;
                }
            }
            apples--;
            if (who.equals("Cat")) catCount++;
            else dogCount++;
            System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            lock.notifyAll(); // 대기풀에 번호 받은 스레드 복귀
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}