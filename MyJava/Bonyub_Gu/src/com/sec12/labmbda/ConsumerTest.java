package com.sec12.labmbda;

import java.util.function.Consumer;
import java.util.function.BiConsumer;

public class ConsumerTest {
	
	//Consumer : 특정 작업 수행후 반환값 X (Void) !

	public static void main(String[] args) {
		Consumer<String> c = s -> System.out.println(s); 
		c. accept ("abc");
		
		Consumer<String> c1 = s -> System.out.println("c1=" + s); 
		Consumer<String> c2 = s -> System.out.println("c2=" + s); 
		Consumer<String> c_res= c1. andThen (c2); 
		c_res.accept("abc");
		
		//Q1 . public interface BiConsumer<T , U>100, 200 입력받아서 합 출력.
		
		BiConsumer<Integer, Integer> sum = (a1,a2) -> System.out.println("sum = " + (a1+a2));
		
		sum.accept(100, 200);
		
	}

}
