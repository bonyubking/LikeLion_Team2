package com.sec07.exam;

public class AA {
	private int a;
	private int b;
	
	public AA(int a,int b) {
		this.a=a;
		this.b=b;
	}
	public AA() {
		System.out.println("AA 기본 생성자.");
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getSum() {
		return getA()+getB();
	}
	

}
