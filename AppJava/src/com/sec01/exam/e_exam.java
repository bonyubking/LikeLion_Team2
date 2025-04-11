package com.sec01.exam;

/*
 * 4칙 연산을 하고 싶다
 * 100 + 200 =
 * 200 - 100 = 
 * 100 * 200 = 
 * 200 / 100 = 
 * 
 * 다음에 대해 순서대로 지정해야함
 * 선언, 값대입, 연산, 출력
 * */
public class e_exam {
	
	public static void calc() {
		//선언 -> 지역변수 선언
		int a,b,sum, sub, mul;
		double div;
			
		//값대입
		a = 100;
		b = 200;
		sum = sub = mul = 0;
		div = 0.0;
				
		//연산
		sum = a+b;
		sub = b-a;
		mul = a*b;				
		div = b/a;
		//출력 
		System.out.println("sum 결과:"+sum);
		System.out.println("sub 결과:"+sub);
		System.out.println("mul 결과:"+mul);
		System.out.println("div 결과:"+div);
	}
	
	public static void calc2() {
		//선언 -> 지역변수 선언
		int a,b,sum, sub, mul;
		double div;
			
		//값대입
		a = 100;
		b = 200;
		sum = sub = mul = 0;
		div = 0.0;
				
		//연산
		sum = a+b;
		sub = b-a;
		mul = a*b;				
		div = b/a;
		//출력 
		System.out.printf("%5d+%5d=%5d\n",a,b,sum);
		System.out.printf("%5d-%5d=%5d\n",b,a,sub);
		System.out.printf("%5d*%5d=%5d\n",a,b,mul);
		System.out.printf("%5d/%5d=%.2f\n",b,a,div);
	}

	public static void main(String[] args) {
		calc();
		calc2();

	} 

}
