package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread {
    public static void main(String[] args) throws InterruptedException {
    	
    	//가상 스레드 1000 생성
        for (int i = 0; i < 1000; i++) {
            Thread.startVirtualThread(() -> {
                try {
                	System.out.println("Virtual Thread: " + Thread.currentThread());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        Thread.sleep(4000); // 메인 스레드가 가상 스레드 종료를 기다림 -> 메인 스레드는 4초간 대기 후 종료
        // VirtualVM 실행 -> Threads 탭 -> 스레드가 실행할 때 일시적으로 Thread 수가 늘었다 줌 
    }
}
