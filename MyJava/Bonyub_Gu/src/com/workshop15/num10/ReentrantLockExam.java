package com.workshop15.num10;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExam {

	public static void main(String[] args) {
		
		BoundedBuffer buffer = new BoundedBuffer();
		
		Thread producer = new Thread(()-> {
			
			int item = 1;
			try {
				while(true) {
					buffer.put(item++);
					Thread.sleep(500);
				}
				
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("생성자 인터럽트 종료");

			}
			
			
		}, "producer");
		
		Thread consumer = new Thread(()-> {
			
			
			try {
				while(true) {
					buffer.take();
					Thread.sleep(1000);
				}
				
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("소비자 인터럽트 종료");
			}
			
			
		},"consumer");
		producer.start();
		consumer.start();


	}

}


class BoundedBuffer {
	   final Lock lock = new ReentrantLock();
	   final Condition notFull  = lock.newCondition(); 
	   final Condition notEmpty = lock.newCondition(); 

	   final Object[] items = new Object[5];
	   int putptr, takeptr, count;

	   public void put(Object x) throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == items.length) {
	    	   System.out.println("버퍼 가득 참 - 생산자 대기");
	         notFull.await(); }
	         
	       items[putptr] = x;
	       System.out.printf("생산 -> [%s] (버퍼 : %d %d ) \n", x, count+1, items.length);
	       if (++putptr == items.length) putptr = 0;
	       count++;
	       
	       notEmpty.signal();
	     } finally {
	       lock.unlock();
	     }
	   }

	   public Object take() throws InterruptedException {
	     lock.lock();
	     try {
	       while (count == 0) {
	    	   System.out.println("버퍼 비어있어 - 대기해줘");
	         notEmpty.await(); }
	       
	       
	       Object x = items[takeptr];
	       System.out.printf("소비 -> [%s] (버퍼 : %d %d ) \n", x, count+1, items.length);

	       takeptr = (takeptr + 1) % items.length;
	       count--;
	       
	       notFull.signal();
	       return x;
	     } finally {
	       lock.unlock();
	     }
	   }
	   
	   
	   
	   
	 }


