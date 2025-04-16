package com.sec16;

//  Virtual Threads (JDK 21) - 람다 표현식 사용
public class g_VirtualThread2 {
    public static void main(String[] args) throws InterruptedException {
    	
        Thread.Builder builder = Thread.ofVirtual().name("my-", 0);

        switch (builder) {
            case Thread.Builder.OfVirtual v -> {
                Thread thread = v.start(() -> {
                    System.out.println("실행 중: " + Thread.currentThread());
                    try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                });
                thread.join();
            }
		default -> throw new IllegalArgumentException("Unexpected value: " + builder);
        }
    }
}
