package com.sec04;

public class ForTest04 {	
	public static void main(String[] args) {
	
	    for(int i=1; i<=5; i++) {
            for(int j=1; j<=i; j++) {
                System.out.printf("%3c",'*');
            }
            System.out.println();
        }
	    
	   for(int i = 0; i < 5; i++) {
		   for(int j=0;j<i+1;j++) {
			   System.out.print("*");
		   }
		   System.out.println();
	   }
	}
}


