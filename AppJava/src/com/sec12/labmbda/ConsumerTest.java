package com.sec12.labmbda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {
		//입력값을 받아 특정 작업 수행하고 반환값이 없는 인터페이스 void accept(T t)
		Consumer<String> c = s -> System.out.println(s); 
		c. accept ("abc");
		
		Consumer<String> c1 = s -> System.out.println("c1=" + s); 
		Consumer<String> c2 = s -> System.out.println("c2=" + s); 
		Consumer<String> c_res= c1. andThen (c2); 
		c_res.accept("abc");
		
		//Q1. public interface BiConsumer<T,U>를 이용해 100,200 입력받아 합 출력
		BiConsumer<Integer,Integer> sum  = (a,b) -> System.out.println("sum ="+(a+b));
		sum.accept(100, 200);
	}

}
