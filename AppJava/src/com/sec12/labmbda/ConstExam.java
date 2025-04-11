package com.sec12.labmbda;

import java.util.function.BiFunction;
import java.util.function.Supplier;

class AA{
	int a;
	int b;
	public AA() {
		a=100;
		b=200;
	}
	public AA(int a, int b) {
		super();
		this.a=a;
		this.b=b;
		
	}
	
	@Override
	public String toString() {
		return String.format("AA [a=%s, b=%s]",a, b);
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
		return (b!=0) ? a/b : Double.NaN;
	}
}
public class ConstExam {

	public static void main(String[] args) {
		Supplier<AA> res = AA::new; //기본생성자 ::
		AA obj1 = res.get(); //Supplier 타입이라서 get 실행하면 생성자가실행됨
		System.out.println(obj1);//obj.toString()
		
		BiFunction<Integer,Integer,AA> res02 = AA::new;
		AA obj2 = res02.apply(100,200);
		System.out.println(obj2);
		
		Supplier<Integer> addRes = obj2::add; //::을 이용해 add함수 실행
		Supplier<Integer> subRes = obj2::sub;
		Supplier<Integer> mulRes = obj2::mul;
		Supplier<Double> divRes = obj2::div;
		System.out.println("+ =>"+addRes.get()); //get메소드를 이용해 값을 리턴받음
		System.out.println("- =>"+subRes.get());
		System.out.println("* =>"+mulRes.get());
		System.out.println("/ =>"+divRes.get());

	}

}
