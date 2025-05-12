package com.sec06;

import java.util.Objects;

public class U_Address {

	private String name;
	private String addr;
	private String tel;
	
	
	public U_Address(String name) {
		super();
		this.name = name;
		this.addr = "서울";
		this.tel = "02-000";
	}
	
	
	public U_Address(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
		
	


	@Override
	public int hashCode() {
		return Objects.hash(name);
	}



	@Override
	public boolean equals(Object obj) {
		U_Address other = (U_Address) obj;
		return Objects.equals(this.name, other.name);
	}



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
		U_Address a1 = new U_Address("홍길동", "111", "111");
		U_Address a2 = new U_Address("정길동", "1131", "111");
		
		System.out.println(a1.equals(a2));

	}


}


