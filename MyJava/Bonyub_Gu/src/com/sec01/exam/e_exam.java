package com.sec01.exam;
/*
 * 사칙연산 한다
 * 조건1 : 수행결과를 calc()로 구현해서 메인에서 호출
 */

public class e_exam {
	
	public static void calc() {
		
		int a,b,hap,sub,mul;
		double div;
		
		a=100;
		b=200;
		hap = sub = mul = 0;
		div = 0.0;
		
		hap = a+b;
		sub = b-a;
		mul = a*b;
		div = b/a;
		
		System.out.println(a+"+"+b+"="+hap);
		System.out.println(b+"-"+a+"="+sub);
		System.out.println(a+"*"+b+"="+mul);
		System.out.println(b+"/"+a+"="+div);
	}
	
	
	public static void calc02() {
			
			int a,b,hap,sub,mul;
			double div;
			
			a=100;
			b=200;
			hap = sub = mul = 0;
			div = 0.0;
			
			hap = a+b;
			sub = b-a;
			mul = a*b;
			div = b/a;
			
			System.out.printf("%5d + %5d = %5d \n", a,b,hap);
			System.out.printf("%5d - %5d = %5d \n", b,a,sub);
			System.out.printf("%5d * %5d = %5d \n", a,b,mul);
			System.out.printf("%5d / %5d = %.2f \n", b,a,div);
		}
	
	public static void main(String[] args) {
		calc();
		calc02();
	}

}
