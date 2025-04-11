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
public class j_exam {

	public static void main(String[] args) {
		//선언 -> 지역변수 선언
		int a,b,sum, sub, mul;
		double div;
		
		//값대입
		a = 100;
		b = 200;
		sum = sub = mul = 0;
		div = 0.0;
		
		Calc calc = new Calc();
		//연산
		sum = Calc.getSum(a,b);
		sub = Calc.getSub(a,b);
		mul = Calc.getMul(a,b);
		div = Calc.getDiv(a,b);
		//출력 
		System.out.println("sum 결과:"+sum);
		System.out.println("sub 결과:"+sub);
		System.out.println("mul 결과:"+mul);
		System.out.println("div 결과:"+div);
	    calc.nonStatic();

	} 

}