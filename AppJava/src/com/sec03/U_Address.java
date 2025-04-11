package com.sec03;


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
	
	//멤버 메소드 
	
	public static void main(String [] args) {
    	U_Address a1 = new U_Address();
    	U_Address b1 = new U_Address();
    	
    	a1.setName("111");
    	a1.setAddr("111");
    	a1.setTel("111");
    	System.out.println(a1);
    	
    }

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
	
}
