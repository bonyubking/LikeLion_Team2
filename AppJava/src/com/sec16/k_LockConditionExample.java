package com.sec16;

import java.util.concurrent.locks.*;

// [Lock + Condition] 스레드 간 정교한 통신
public class k_LockConditionExample {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {
        Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                while (!ready) {
                    System.out.println(" 대기 중...");
                    condition.await();
                }
                System.out.println("✅ 조건 만족됨! 계속 진행.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        });

        Thread signaler = new Thread(() -> {
            lock.lock();
            try {
                ready = true;
                condition.signal(); //풀링에서 깨어나 스레드 시작 실행 신호 
                System.out.println("📢 조건 신호 보냄");
            } finally {
                lock.unlock();
            }
        });

        waiter.start();
        Thread.sleep(1000); // signaler보다 먼저 시작
        signaler.start();
    }
}