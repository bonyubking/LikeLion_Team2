package com.sec12.labmbda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;


public class PredicateTest {

	public static void main(String[] args) {
			//boolean test(T t)
			Predicate<String> i  = (s)-> s.length() >10; //(1)
			//문자열 길이가 10 초과 유무 
		    System.out.println(i.test("getting strart java"));	//(2) true	   
		    
		    IntPredicate p1 = n -> (n % 3) == 0; //(3) //3의 배수 판정
		    IntPredicate p2 = n -> (n % 5) == 0;//(4) //5의 배수 판정
		    
		    IntPredicate p_res = p1. and (p2); //(5) //3의 배수이면서 5의 배수인지 판정 
		    System.out.println(p_res.test(3)); //(6) false -> 3의 배수이지만 5의 배수가 아님
		    System.out.println(p_res.test(4)); //(7) false -> 3의 배수도 아니고 5의 배수도 아님
		    
		    IntPredicate p_res02 = p1. or (p2); //(8)3의 배수 또는 5의 배수를 판정
		    System.out.println(p_res02.test(5)); // true 5의 배수 
		    System.out.println(p_res02.test(15)); //true 3의 배수, 5의 배수 
		    
		    
		    Predicate<String> str  = Predicate.isEqual("Dominica_kim");//(9) 문자열이 같은지 다른지 판정함
		    System.out.println(str.test("Dominica_kim"));
		    
		  
	}

}
