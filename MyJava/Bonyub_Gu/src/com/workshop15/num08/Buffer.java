package com.workshop15.num08;

public class Buffer {
	
    private int data = -1;  
    private boolean isProduced = false;
	

	public synchronized void produce(int i) {
		
	    try {
	        while (isProduced) {  
	            wait();
	        }
	        
	        data = i;
	        isProduced = true;
	        System.out.println("생산됨: " + data);
	        notify(); 
	        
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}

    public synchronized void consume() {
        try {
            while (!isProduced) {
                wait(); 
            }
            
            System.out.println("소비됨: " + data);  
            isProduced = false;  
            notify();
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    
    }

}
