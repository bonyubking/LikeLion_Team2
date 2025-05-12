package com.workshop10.num01;

import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.IntStream;


public class Calc {
	
	public static int calculate(int data) {
		
		IntStream lst1 = IntStream.rangeClosed(1, data);
        int ans = lst1.filter(value -> value % 2 == 0).reduce(0, Integer::sum); 
		return ans;
	}
	
}
