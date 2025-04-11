package com.sec12.mstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperationsTest02 {

	public static void main(String[] args) {
		// Q1. 1~100까지 정수 출력
		System.out.println("Q1. 1~100까지 정수 출력");
		IntStream.rangeClosed(1, 100).forEach(e-> System.out.printf("%d ",e));
		
		
		System.out.println("\n\nQ2. 짝수만 출력");
		// Q2. 짝수만 출력
		IntStream.rangeClosed(1, 100)
			.filter(i -> i%2==0)
			.forEach(e->System.out.printf("%d ", e));
		System.out.println();
		
		
		System.out.println("\nQ3. 합 구하기");
		// Q3. 합 구하기
		System.out.println(IntStream.rangeClosed(1, 100).sum());
		
		//Q4. str을 문자열 리스트로 공백 기준 만들어서 5글자 이상인 단어만 필터링 후 모두 대문자로 출력 
		String str = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
		Arrays.stream(str.split("\\s+")) //공백 기준으로 문자열 나누기 
			.filter(word -> word.length()>=5) //나눴을 때 하나의 단어의 길이가 5글자 이상인 것만 필터링 
			.map(String::toUpperCase) //해당 단어들을 모두 대문자로 변경 
			.forEach(word -> System.out.printf("%s ",word)); //단어 출력함 
		
		List<String> result = Arrays.stream(str.split("\\s+"))
				.filter(word -> word.length()>=5)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		result.forEach(word->System.out.printf("%s ",word));
		
			
			
	}

}
