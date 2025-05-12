package com.sec16;

public class g_exam {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Thread.Builder builder = Thread.ofVirtual().name("my-", 0);

		switch (builder) {
		
		    case Thread.Builder.OfVirtual v -> {
		        Thread thread = v.unstarted(() -> {
		            System.out.println("실행 중: " + Thread.currentThread());
		            try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		        });
		        thread.start();
		        
		        try {
		        	thread.join();}
		        catch (InterruptedException e) {
		        	
		        	e.printStackTrace();
		        }
		        
		        long total = System.currentTimeMillis() - start;
		        
		        System.out.println("실행 시간: " + total);
		    }
		default -> throw new IllegalArgumentException("Unexpected value: " + builder);
			
			
		}

	}

}
