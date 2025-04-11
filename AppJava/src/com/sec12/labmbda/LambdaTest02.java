package com.sec12.labmbda;

public class LambdaTest02 {
	@FunctionalInterface
	interface Func{
		public int Calc(int a, int b);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Func add = (a,b) -> a+b;
		Func minus = (a,b) -> a-b;
		Func mul = (a,b) -> a*b;
		Func div = (a,b) -> a/b;
		System.out.println(add.Calc(100, 50));
		System.out.println(minus.Calc(100,50));
		System.out.println(mul.Calc(100, 50));
		System.out.println(div.Calc(100,50));

	}

}
