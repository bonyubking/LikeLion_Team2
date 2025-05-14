package com.sec01;

public class MyAddress {

	private String name;
	private String addr;
	private String tel;
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public MyAddress() {
		this("홍길동","서울시","00-11-22");
	
	}

	public MyAddress(String name) {
		this(name,"부산광역시","11-123-456");
	}
	
	public MyAddress(String name,String addr) {
		this(name,addr,"22-123-456");
	}
	
	public MyAddress(String name,String addr,String tel) {
		this.name=name;
		this.addr=addr;
		this.tel=tel;
	}
	
	@Override
	public String toString() {
		return "MyAddress [name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}

}
