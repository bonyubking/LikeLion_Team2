package com.sec07.exam;

public class BB extends AA{
	private int c;
	private String s;
	
	public BB(int i, int j, int k) {
		super(i,j);
		this.c = k;
		
	}
	
	public BB() {
		System.out.println("BB 기본생성자");
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	public String getS() {
		return s;
	}

	public void setC(String s) {
		this.s = s;
	}
	
	public int getRes() {
		return (getA()+getB())-getC();
	}
	

}
