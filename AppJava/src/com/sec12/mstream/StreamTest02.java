package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest02 {
	
	public static void main(String[] args) {
		
		//Q1. 1~10까지 정수형 값을 스트림 생성 후 출력
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Stream<String> listStream = list.stream().map(String::valueOf);
		//Stream<String> streamValues = Stream.of("1","2","3","4","5","6","7","8","9","10");
		StreamTest02.printStream("Q1",listStream);
		
		//Q2. import java.util.stream.Stream는 문자열을 잘라 배열 만든 후 스트림 생성
		String[] stringArray = "import java.util.stream.Stream".split(" ");
		Stream<String> stream2 = Arrays.stream(stringArray);
		StreamTest02.printStream("Q2",stream2);
		
		
		//Q3. 10~1까지 정수형 값을 스트림 생성 후 출력
		
		
	}
	
	public static void printStream(String title, Stream<String> stream) {
        System.out.println(title);
        stream.forEach(e -> System.out.printf("%5s", e)); // 요소 출력
        System.out.println("\n============================\n");
    }
}
