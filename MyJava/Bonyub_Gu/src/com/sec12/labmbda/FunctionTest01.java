package com.sec12.labmbda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest01 {

	public static void main(String[] args) {
		
		//Interface Bifunction <T, U, R > R apply (T t, U u) -> T U 륿잗아서 R로 리턴
		 BiFunction<String, String,String> bi = (x, y) -> {      
		      return x + y;
		    };
		    
		    // BiFunction<String, String, String> bi = (x, y) -> x+ y;
		    


			System.out.println("bi = " + bi.apply("today is" , " saturday"));
		    	
		    
		    Function<String,String> f = x-> x+" !";		    
		    System.out.println(bi.andThen(f).andThen(f).apply("Getting Start", " java"));
	}
}
