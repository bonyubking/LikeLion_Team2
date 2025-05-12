package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.startVirtualThread(() -> {

                try {
                    System.out.println("Virtual Thread: " + Thread.currentThread());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        Thread.sleep(4000); // 메인 스레드가 가상 스레드 종료를 기다림 -> 메인 스레드 2초 대기후종료
       // VisualVM 실행 -> Threads 탭 -> 스레드가 실행할때 일시적으로 thread수가 늘었다 줄었따,
    }
}
