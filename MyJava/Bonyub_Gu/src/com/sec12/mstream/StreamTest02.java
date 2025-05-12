package com.sec12.mstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest02 {

	public static void main(String[] args) {
		
		// Q1. 1~10까지 정수형 값을 스트림 생성후 출력 정수를 문자열로 -> String.valueof()
		
		
        
		Stream<String> streamFromValues = IntStream.rangeClosed(1, 10).
				mapToObj(String::valueOf);
		StreamTest.printStream("Q1", streamFromValues);
		
		
		// rangeclosed로 역순 스트림 생성하는법
		Stream<String> streamFromValues1 = IntStream.rangeClosed(1, 10).
				map(i-> 11-i).
				mapToObj(String::valueOf);
		StreamTest.printStream("Q1", streamFromValues1);
		 
		//Q3. 10~1까지 정수형 값 스트림 생성 후 출력
		Stream<String> streamFromValues2 = IntStream.iterate(10, i->i-1).
				limit(10).
				mapToObj(String::valueOf);
		StreamTest.printStream("Q1", streamFromValues2);
		
		//Q4 . Stream<Intger> boxed() + sorted() 사용 함
		streamFromValues2 =IntStream.rangeClosed(1, 10).
				boxed().
				sorted((a,b)->b-a).
				map(String::valueOf);
		StreamTest.printStream("Q3", streamFromValues2);
	}

}
