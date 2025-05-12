package com.sec07.exam;
import com.sec07.exam02.AA;

public class BB extends AA {
	

	private int c;
	
	public int getC() {
		return c;
	}
	
	public void setC(int c) {
		this.c = c;
	}
	
	public int getRes() {
		return (getA() + getB()) - getC();
	}
}
