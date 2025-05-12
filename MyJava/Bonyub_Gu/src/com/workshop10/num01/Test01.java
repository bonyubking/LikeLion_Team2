package com.workshop10.num01;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.sec12.mstream.StreamTest;

public class Test01 {

	public static void main(String[] args) {
		
		
        System.out.print("정수를 입력하세요: ");
		Scanner input = new Scanner(System.in);
		int key = input.nextInt();
		
		System.out.printf("짝수의 합 : %d\n", Calc.calculate(key));
		
		Stream<String> streamFromValues = IntStream.rangeClosed(1, key).
				mapToObj(String::valueOf);
		
		System.out.printf("1부터 %d까지의 숫자:\n", key);
		streamFromValues.forEach(e -> System.out.printf("%s ",e));
		System.out.println();
		
		IntStream streamFromValues2 = IntStream.rangeClosed(1, key);
		
		System.out.println("짝수 판별: ");
		streamFromValues2.forEach(e -> System.out.printf("%d (%s) ",e , e%2==0 ? "짝수" : "홀수"));
		
		System.out.println();
		System.out.printf("입력 값 : %d\n",key);
		
		IntStream streamFromValues3 = IntStream.rangeClosed(1, key).filter(e -> e%2 ==0);
		System.out.printf("짝수 리스트 :");
		streamFromValues3.forEach(e -> System.out.printf(" %d",e));
		
		System.out.println();
		IntStream streamFromValues4 = IntStream.rangeClosed(1, key).filter(e -> e%2 ==0);
		System.out.printf("짝수 중 가장 큰 값 : %d ", streamFromValues4.max().orElse(0));
		
		System.out.println();
		IntStream streamFromValues5 = IntStream.rangeClosed(1, key).filter(e -> e%2 ==0);
		System.out.printf("짝수 중 가장 작은 값 : %d ", streamFromValues5.min().orElse(0));
		

	}

}
