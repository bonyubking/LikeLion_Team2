package com.sec12.labmbda;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class PredicateTest02 {

	public static void main(String[] args) {
		// Q1. IntPredicate를 활용해서 짝수이면서 7의 배수인지 판별
		IntPredicate isE = (i) -> i%2==0;
		IntPredicate isM7 = (i) -> i%7==0;
		
		IntPredicate result = isE.and(isM7);
		System.out.println(result.test(10));
		
		//Q2. Interface BiPredicate<T,U>를 사용해 보자
		BiPredicate<Integer,Integer> bi = (x,y) -> x > y;
		System.out.println(bi.test(7,10));

	}

}
