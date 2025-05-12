package com.workshop13.num03;

import java.util.ArrayList;

public class ListTest02 {
	
	
	public static void main(String[] args) {
		
		ConvertList c1 = new ConvertList();
		int array[] = {3,4,2,5,2,3,6,7,5,7,9}; 
		
		ArrayList<Integer> Anslist = c1.convertList(array);
		
		for (Integer i: Anslist){
			System.out.println(i);
		}
	}
}
