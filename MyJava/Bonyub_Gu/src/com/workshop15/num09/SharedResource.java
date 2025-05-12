package com.workshop15.num09;

import java.util.concurrent.locks.*;

public class SharedResource extends Thread{
	
	private static final Lock lock = new ReentrantLock();
	
	
	public void safeAccess() {
        lock.lock();
        try {
                System.out.println("잠금 획득");
            }

         finally {


            System.out.println("잠금 해제");
            lock.unlock();
        }
    }


}
