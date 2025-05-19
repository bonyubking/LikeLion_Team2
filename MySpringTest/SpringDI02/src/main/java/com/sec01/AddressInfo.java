package com.sec01;

public class AddressInfo {
	private MyAddress address;
	private int num;

	public void setNum(int num){
		this.num = num;
	}

	public void setAddress(MyAddress myaddress) {
		this.address = myaddress;
	}
	
	public void prn() {
		System.out.println(address.toString());
		System.out.println(this.num);
	}
}
