package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest03 {
	
	public static void main(String[] args) {
		
		//Q1. 1~10까지 정수형 값을 스트림 생성 후 출력 map() : 요소 반환 -> 정수를 문자열로 반
		Integer[] intArr = {1,2,3,4,5,6,7,8,9,10};
		//Integer 타입(Wrapper)으로 생성된 배열이어야 아래 stream()에서 배열 쓸 수 있음 
		Stream<String> listStream = Arrays.stream(intArr).map(String::valueOf);
		//Stream<String> streamValues = Stream.of("1","2","3","4","5","6","7","8","9","10");
		StreamTest03.printStream("Q1",listStream);
		
		//Q2. import java.util.stream.Stream는 문자열을 잘라 배열 만든 후 스트림 생성
		String[] stringArray = "import java.util.stream.Stream".split(" ");
		Stream<String> stream2 = Arrays.stream(stringArray);
		StreamTest03.printStream("Q2",stream2);
		
		
		//Q3. 10~1까지 정수형 값을 스트림 생성 후 출력
		Integer[] intArr02 = {10,9,8,7,6,5,4,3,2,1};
		Stream<String> streamValue03 = Arrays.stream(intArr02).map(String::valueOf);
		StreamTest03.printStream("Q3", streamValue03);
		
		IntStream streamForInteger = IntStream.of(1,2,3,4,5);
	}
	
	public static void printStream(String title, Stream<String> stream) {
        System.out.println(title);
        stream.forEach(e -> System.out.printf("%5s", e)); // 요소 출력
        System.out.println("\n============================\n");
    }
}
