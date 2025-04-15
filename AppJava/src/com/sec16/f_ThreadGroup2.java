package com.sec16;

/*
 * AA
 *   A-1
 *   A-2
 * BB
 *   B-1
 *   B-2
 * */
public class f_ThreadGroup2 {
    public static void main(String[] args) {
        // 1. 스레드 그룹 생성
        ThreadGroup group_A = new ThreadGroup("AA");
        ThreadGroup group_B = new ThreadGroup("BB");
        
        // 2. Runnable 정의
        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            ThreadGroup tg = Thread.currentThread().getThreadGroup();
            for (int i = 0; i < 3; i++) {
                System.out.println("[" + tg.getName() + "] " + name + " - " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // 3. 그룹에 속한 스레드 생성
        Thread a_1 = new Thread(group_A, task, "Thread-A-1");
        Thread a_2 = new Thread(group_A, task, "Thread-A-2");
        
        Thread b_1 = new Thread(group_B, task, "Thread-B-1");
        Thread b_2 = new Thread(group_B, task, "Thread-B-2");

        // 4. 실행
        a_1.start();
        a_2.start();
        
        b_1.start();
        b_2.start();

        // 5. 그룹 정보 출력
        System.out.println("활성 스레드 수: " + group_A.activeCount());
        group_A.list();
        
        System.out.println("활성 스레드 수: " + group_B.activeCount());
        group_B.list();
    }
}
