package com.sec12.labmbda;

import java.util.function.Function;

public class FunctionTest {

	public static void main(String[] args) {
		
		    Function<Integer,String> M_fun = (i)-> Integer.toString(i);	  
		    
		    //위에서 Integer.toString해서 apply(100)을 하면 string으로 변경되어
		    //길이 출력이 가능한 것 
		    System.out.println(M_fun.apply(100).length());
		    System.out.println(M_fun.apply(1000).length());
	}
}
