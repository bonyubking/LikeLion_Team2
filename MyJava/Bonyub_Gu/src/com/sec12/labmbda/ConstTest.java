package com.sec12.labmbda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

class AA{
	int a;
	int b;
	
	public AA() {
		a = 100;
		b = 200;
	}
	
	public AA(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return String.format("AA [a=%s, b=%s]", a, b);
	}
	
	public int add() {
		return a+b;
	}
	public int sub() {
		return a-b;
	}
	public int mul() {
		return a*b;
	}
	public double div() {
		return (b != 0) ? (double) a/b : Double.NaN;
	}
	
}

public class ConstTest {

	public static void main(String[] args) {
		Supplier<AA> res = AA::new;
		AA obj1 = res.get();
		System.out.println(obj1);
		
		BiFunction<Integer, Integer, AA> res02= AA::new;
		
		AA obj2 = res02.apply(100, 200);
		AA obj3 = res02.apply(200, 0);
		
		Supplier<Integer> addRes = obj3::add;
		Supplier<Integer> subRes = obj3::sub;
		Supplier<Integer> mulRes = obj3::mul;
		Supplier<Double> divRes = obj3::div;
		
		System.out.println("+ = " + addRes.get());
		System.out.println("- = " + subRes.get());
		System.out.println("* = " + mulRes.get());
		System.out.println("/ = " + divRes.get());
		System.out.println(obj2);
		
	}

}
