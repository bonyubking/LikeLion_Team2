package com.sec07.mytest;

public class DD extends BB{
	private int d;
	
	public DD() {
		System.out.println("DD' 기본성생자.");
		
	}
	
	

	public DD(int i, int j, int k, int l) {
		super(i,j,k);
		this.d = l;
	}



	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}
	
	@Override
	public int getRes() {
		return super.getRes() * getD();
	}
	
	public static void main(String[] args) {
		
		DD d1 = new DD();
		d1.setA(100);
		d1.setB(200);
		d1.setC(200);
		d1.setD(10);
		System.out.println(d1.getRes());
		
	}
}
