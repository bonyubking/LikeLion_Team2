package com.sec16;

public class f_ThreadGroup2 {
    public static void main(String[] args) {
        // 1. 스레드 그룹 생성
        ThreadGroup groupA = new ThreadGroup("MyThreadGroup");
        ThreadGroup groupB = new ThreadGroup("MyThreadGroup");
        
        // 2. Runnable 정의
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            ThreadGroup tg = Thread.currentThread().getThreadGroup();
            for (int i = 0; i < 3; i++) {
                System.out.println("[ 그룹이름 : " + tg.getName() + "] " + name + " - " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 3. 그룹에 속한 스레드 생성
        Thread t1 = new Thread(groupA, task, "Thread-A-1");
        Thread t2 = new Thread(groupA, task, "Thread-A-2");
        
        Thread t3 = new Thread(groupB, task, "Thread-B-1");
        Thread t4 = new Thread(groupB, task, "Thread-B-2");


        // 4. 실행
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // 5. 그룹 정보 출력
        System.out.println("그룹 A 활성 스레드 수: " + groupA.activeCount());
        System.out.println("그룹 B 활성 스레드 수: " + groupB.activeCount());
        groupA.list();
        groupB.list();
    }
}
