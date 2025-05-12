package com.workshop12.num05;

import java.util.Arrays;

public class StringTest01 {

	public static void main(String[] args) {
		
		String str = "I am second to none";
		
		str.chars().filter(c -> Character.isLetter(c))
		.mapToObj(c -> (char) c)
		.forEach(c -> System.out.print(c + " "));

		System.out.println();
		
		long num1 = str.chars().filter(c -> Character.isLetter(c))
		.count();
		
		System.out.println("문자 갯수 :" + num1);
		
        System.out.println(str);
        
        long num2 = Arrays.stream(str.split(" "))
                .count();
        
        System.out.println("단어 갯수 :" + num2);
       
		
		
	}

}
