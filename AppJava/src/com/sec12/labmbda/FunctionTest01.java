package com.sec12.labmbda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest01 {

	public static void main(String[] args) {
		 BiFunction<String, String,String> bi = (x, y) -> {      
		      return x + y;
		    };
		    
		    String res = bi.apply("오늘은","금요일이다!!");
		    System.out.println("bi = "+res);
		    
		    Function<String,String> f = x-> x+" !";		    
		    //Bifunction의 default <V> andThen(Function<? super R,? extends V>
		    //결합(apply)을 먼저 하고 andThen이 실행됨
		    //f는 입력된 문자열에 ! 를 추가하는 것 
		   //현재는 f에 Getting Start Java라는 문자열이 전달되어 !가 합쳐지는 연산이 두번 진행되는 것 
		    System.out.println(bi.andThen(f).andThen(f).apply("Getting Start", " java"));
	}
}
