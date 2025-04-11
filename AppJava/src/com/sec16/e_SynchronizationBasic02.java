package com.sec16;

// [7. 동기화 기초] - synchronized 메서드 사용
/*
 * 두 개의 스레드가 하나의공유변수를 동시에 증가시키는 상황 
 * 동기화블록을 사용해 경쟁조건을 방지하는 구조 
 * 
 * */
public class e_SynchronizationBasic02 {
    public static void main(String[] args) throws InterruptedException {
        //람다식에서 외부변수를 참조할 때 final 
    	final int[] count = {0}; //배열 상수 :배열은 참조값이 변하지 않음 

    	// count[0]을 1000번 증가시키는 작업 수행 
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
            	// count 객체에 잠금을 걸고 그블록 안의 코드가 실행되지 않도록 함
            	// 하나의 스레드가 증가연산 마칠때까지 다른 스레드는 대기 .
                synchronized (count) { //하나의 스레드만 접근 가능하도록 만들어줌 
                    count[0]++;
                }
            }
        };

        // 두 개 스레드가 동시에 incrementTask 실행 
        // 각각 count[0]을 1000번 증가시키려 함 
        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        //만일 조인을 주지 않으면 메인스레드가 thread1, thread2가 끝나기 전에 출력을 실행함 
        //조인을 줘야 동기화 출력 결과를 정확하게 리턴 받을 수 있음 
        thread1.start();
        thread2.start();
        //thread1.join(); //스레드가 종료할때까지 기다림 
        //thread2.join(); //스레드가 종료할때까지 기다림 

        //join 없으면 메인스레드가 먼저 실행함. 그래서 0 출력 
        System.out.println("Final Count: " + count[0]);
        
       /*실행결과 테스트
        * 1. synchronized O , join O -> Final Count:2000
        * 2. synchronized X , join -> Final Count가 2000보다 낮게나옴
        * 3. synchronized , join X -> Final Count가 0 1000 1500이 랜덤으로 나옴 
        * 
        * 멀티스레드는 항상 synchronized(공유자원LOCK), join(대기)을 고려해서 프로그램을 작성함 
        * 
        * */
    }
}