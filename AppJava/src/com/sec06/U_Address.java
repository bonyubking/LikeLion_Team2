package com.sec06;

import java.util.Objects;

/*
 * 이름 주소 전화번호
 * --------------
 * 홍길동 서울 02-000-0000 a1
 * 정길동 인천 032-000-0000 b1
 * 최길동 부산 051-000-0000 c1 
 * */

public class U_Address{
	
	//멤버변수 은닉화
	private String name;
	private String addr;
	private String tel;
	
	public U_Address() {
	//기본생성자 -> 아무런 매개변수가 없는 것 
		super();
		
	}
	
	public U_Address(String name) {
		super();
		this.name = name;
		this.addr="서울";
		this.tel="02-0000";
	}
	
	public U_Address(String name,String addr, String tel) {
		super();
		this.name = name;
		this.addr=addr;
		this.tel=tel;
	}
	
	//멤버 메소드 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "U_Address [getName()=" + getName() + ", getAddr()=" + getAddr() + ", getTel()=" + getTel() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		U_Address other = (U_Address) obj;
		return Objects.equals(name, other.name);
	}
	
	public static void main(String[] args) {
		U_Address u1 = new U_Address("홍길동","111","111");
		U_Address u2 = new U_Address("홍길동","111","111");
		
		System.out.println(u1.equals(u2));
		System.out.println(u1.hashCode());
	}
	
}
