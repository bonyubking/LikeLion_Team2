package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread2 {
    public static void main(String[] args) throws InterruptedException {
    	
    	Thread.Builder builder = Thread.ofVirtual();

    	switch(builder) {
    	case Thread.Builder.OfVirtual v -> System.out.println("가상 스레드 생성");
    	case Thread.Builder.OfPlatform p -> System.out.println("플랫폼 스레드 생성");
    	}

        Thread.sleep(4000); // 메인 스레드가 가상 스레드 종료를 기다림 -> 메인 스레드는 4초간 대기 후 종료
        // VirtualVM 실행 -> Threads 탭 -> 스레드가 실행할 때 일시적으로 Thread 수가 늘었다 줌 
    }
}
