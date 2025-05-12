package com.workshop13.num01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SetTest {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String key = input.nextLine();
	
		Set<Character> charSet = key.chars()                 
			    .mapToObj(c -> (char)c)                         
			    .collect(Collectors.toSet());
		
		System.out.println(charSet);
		
		
	}

}
