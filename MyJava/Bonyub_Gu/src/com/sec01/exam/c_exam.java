package com.sec01.exam;

/*
 * 사칙연산 연습
 * 100 + 200 = 
 * 200 - 100 =
 * 100 * 200 =
 * 200 / 100 =
 */

public class c_exam {
	
	public static void main(String[] args) {
		
		//선언 -> 지역변수
		int a,b,hap,sub,mul,div;
		
		a=100;
		b=200;
		hap = sub = mul = div =0;
		
		hap = a+b;
		sub = b-a;
		mul = a*b;
		div = b/a;
		
		System.out.println(a+"+"+b+"="+hap);
		System.out.println(b+"-"+a+"="+sub);
		System.out.println(a+"*"+b+"="+mul);
		System.out.println(b+"/"+a+"="+div);
	}

}
