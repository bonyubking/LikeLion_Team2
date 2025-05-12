package com.sec12.labmbda;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;

public class PredicateTest02 {

	public static void main(String[] args) {
			// Q1 .IntPredicate 5 and 7 배수 ㅍ판별.
		
		IntPredicate p1 = n -> (n % 5) == 0;
		IntPredicate p2 = n -> (n % 7) == 0;
		IntPredicate ans = p1. and (p2);
		
		System.out.println(ans.test(12));
		System.out.println(ans.test(35));
		
		BiPredicate<Integer,Integer> bi = (x,y) -> x > y;
		System.out.println(bi.test(10, 8));
		
		

	}

}
