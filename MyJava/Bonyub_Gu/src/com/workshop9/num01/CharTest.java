package com.workshop9.num01;

import java.util.Scanner;
import java.util.stream.IntStream;

public class CharTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String keyword = sc.nextLine();
		
        IntStream.range(0, keyword.length())
        .mapToObj(i -> Character.toUpperCase(keyword.charAt(keyword.length() - 1 - i)))
        .forEach(System.out::print);

        System.out.println();

	}

}
