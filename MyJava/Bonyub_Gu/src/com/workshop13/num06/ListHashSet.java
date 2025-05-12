package com.workshop13.num06;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ListHashSet { 
	public static void main(String[] args) { 
		
		Random rand = new Random();
		Scanner size = new Scanner(System.in);
		int key = size.nextInt();

	
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		HashSet<Integer> set = new HashSet<Integer>(); 
		

		
		for (int i=0; i<key; i++) {
			 int ranNum = rand.nextInt(1,11);
			 list.add(ranNum);
		}
		
		for (Integer i : list){
			
			set.add(i);
		}
		
		for (Integer i : list) {
		System.out.printf("%d ",i);
		}
		System.out.println();
		System.out.println(set);
		
		}         
	 
} 
