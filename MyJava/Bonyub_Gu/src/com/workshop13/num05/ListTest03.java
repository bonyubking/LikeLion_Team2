package com.workshop13.num05;

import java.util.ArrayList;
import java.util.Random;

public class ListTest03 {

	public static void main(String[] args) {
	     
		Random rand = new Random();
		int key = 0;
		ArrayList<Integer> list1 = new ArrayList<Integer>(); 
	    ArrayList<Integer> list2 = new ArrayList<Integer>();
	    
	    
	    for (int i=0; i<10; i++) {
	    	list1.add(rand.nextInt(10));
	    	list2.add(rand.nextInt(10));

	    }
	    
	    for (int i=0; i<10; i++) {
	    	
	    	try{key = list1.get(i) / list2.get(i);
    		System.out.printf("%d/%d %d", list1.get(i),list2.get(i),key);
	    		}
	    		catch (ArithmeticException e) {
	    			System.out.printf("%d/%d 분모가 0입니다",list1.get(i),list2.get(i));
	    		}

	    	System.out.println();
	    	
	    }
	}

}
