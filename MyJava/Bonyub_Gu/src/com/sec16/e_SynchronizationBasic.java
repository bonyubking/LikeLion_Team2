package com.sec16;

// 동기화 기초 - synchronized 메서드 사용
public class e_SynchronizationBasic {
    public static void main(String[] args) throws InterruptedException {
    	
    	//람다 식에서 외부 변수를 참조할떄 final 이여야한다
        final int[] count = {0};

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (count) {
                    count[0]++;
                }
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Final Count: " + count[0]);
        
        
        //실행 결과 테스트해보자
        // 1. synchronized O  join O -- > Final Count : 2000
        // 2. synchronized X, join O -- > Final Count : 2000보다 낮음
        // 3. synchronized X, join X -- > Final Count : 0 , 1000, 1500 (랜덤) (스레드 종료 시점)
        // 4.
    }
}