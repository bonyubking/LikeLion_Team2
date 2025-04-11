package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest04 {
	
	public static void main(String[] args) {
		
		//Q1. 1~10까지 정수형 값을 스트림 생성 후 출력 map() : 요소 반환 -> 정수를 문자열로 반
		Stream<String> listStream = IntStream.rangeClosed(1,10).mapToObj(String::valueOf);
		//Stream<String> streamValues = Stream.of("1","2","3","4","5","6","7","8","9","10");
		StreamTest04.printStream("Q1",listStream);
		
		//Q2. 1~10까지 정수형 값을 스트림 생성 후 출력
		Stream<String> stringArray = IntStream.iterate(10, i->i-1).limit(10).mapToObj(String::valueOf);
		StreamTest04.printStream("Q2. 1~10까지의 정수형 값을 스트림 생성 후 출력", stringArray);
		
		
		//Q3. 10~1까지 정수형 값을 스트림 생성 후 출력
		Stream<String> streamValues = IntStream.rangeClosed(1, 10) //1~10 정수 스트림
										.map(i->11-i) //역순까지 리턴
										.mapToObj(String::valueOf); //문자열 변환 -> 스트림 생성 후 리턴
		StreamTest04.printStream("Q3. 10~1까지 역순 출력",streamValues);
		
		
		//Q4. Stream<Integer> boxed() + sorted(Comparator.reverseOrder()) 사용함
		streamValues = IntStream.rangeClosed(1, 10)
						.boxed() //기본형 int -> Integer 변환
						.sorted((a,b)-> b-a) //역순 내림차순 
						.map(String::valueOf);   
	}
	
	public static void printStream(String title, Stream<String> stream) {
        System.out.println(title);
        stream.forEach(e -> System.out.printf("%5s", e)); // 요소 출력
        System.out.println("\n============================\n");
    }
}
