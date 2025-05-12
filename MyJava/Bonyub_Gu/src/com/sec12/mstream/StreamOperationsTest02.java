package com.sec12.mstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperationsTest02 {

	public static void main(String[] args) {		
		// Q1. 1~100 정수 출력
		IntStream streamFromValues1 = IntStream.rangeClosed(1, 100);
		IntStream streamFromValues3 = IntStream.rangeClosed(1, 100);
		
		Stream<String> streamFromValues2 = IntStream.rangeClosed(1, 100).boxed().map(String::valueOf);
		
		StreamTest.printStream("",streamFromValues2);
		
		// Q2. 정수 출력
		
		streamFromValues1.filter(value -> value % 2 == 0)
        .forEach(e-> System.out.printf("%5d",e));
		
		System.out.println();
		
		int sum1 = streamFromValues3.sum();
		// Q3. 합 출력
		System.out.printf("%5d",sum1);
		
		
		// Q4. str을 문자열 리스트 공백 기준 만들어서, 5글자 이상 단어만 필터링 후 대문자로 출력
		String str = "Returns a composed Consumer that performs, in sequence, this operation followed by the after operation.";
		Arrays.stream(str.split("\\s+"))
				.filter(word -> word.length() >= 5)
				.map(String::toUpperCase)
				.forEach(word -> System.out.printf("%10s", word));
		
		System.out.println();
		
		List<String> result 
			= Arrays.stream(str.split("\s+"))
			.filter(word -> word.length() >= 5)
			.map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(result);
	}

}
