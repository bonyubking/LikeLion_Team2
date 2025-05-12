package com.sec03;

public class U_Address {

	private String name;
	private String addr;
	private String tel;

	/////// 멤버 메소드 생성

	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr() {
		return addr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}
	
	public void Prn() {
		System.out.printf("%10s %10s %10s\n", this.getName(), this.getAddr(), this.getTel());
		
	}
	
	@Override
	public String toString() {
		return String.format("U_Address [getName()=%s, getAddr()=%s, getTel()=%s]", getName(), getAddr(), getTel());
	}
	
	
	public static void main(String[] args) {
		U_Address a1 = new U_Address();
		U_Address b1 = new U_Address();
		
		a1.setName("111");
		a1.setAddr("111");
		a1.setTel("111");
		
		System.out.println(a1);
		System.out.println(b1);
	}


}


