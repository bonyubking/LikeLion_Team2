package com.sec16.appletree;

// case 2: Object -> wait(); / notifyAll();
// ThreadPool을 대기했다가 다시 실행하도록 만듦
/*
 * Dog 스레드가 pickApple 호출 -> 사과 3개 -> 하나 따고 notifyAll 
 * Cat 스레드가 PickApple 호출 -> 사과 있음 -> 사과 따고 notifyAll 
 * 사과 0되면 Dog 스레드/Cat 스레드는 wait()에 걸림 
 * 대기 후에도 사과가 없으면 return false 
 * */
public class AppleTreeCase3_WaitNotify extends AppleTreeCompetition {
    private final Object lock = new Object(); // 동기화를 위한 객체. 반드시 wait, notifyAll은 이 객체의 monitor 가지고 있어야함 

    protected boolean pickApple(String who) {
        synchronized (lock) { // 한번에 한 스레드만 접근 가능한 블록 
            while (apples <= 0) { // 사과가 없으면 wiat() 으로 기다림 상태에 들어감. notifyAll()로 다른 스레드가 깨워줘야. 
                try {
                    lock.wait(); //조건 충족되지 않으면 스레드로 일시정지됨 
                    return false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return false; // 대기 후에도 사과가 없으면 더이상 따지 않기 위해 false 반환 
                }
            }
            apples--; 
            if (who.equals("Cat")) catCount++;
            else dogCount++; //사과 개수 줄이고 누가 땄는지에 따라 catCout/dogCount 계산 
            System.out.println(who + "가 사과를 땄습니다. 남은 사과: " + apples);
            lock.notifyAll(); //wait() 중인 모든 스레드 깨움 
        }
        try { Thread.sleep((int)(Math.random() * 2)); } catch (InterruptedException e) { }
        return true;
    }
}