package com.workshop12.num03;

import java.util.List;

public class StreamAnswer1 {

	public static void main(String[] args) {
		
		List<String> names = List.of("Tom", "Jerry", "Mike", "James", "Anna", "Sue");
		
		names.stream().filter(name -> name.length() > 3)
		.sorted().forEach(name -> System.out.println(name));

	}

}
