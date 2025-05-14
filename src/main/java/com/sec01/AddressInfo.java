package com.sec01;

public class AddressInfo {
	private MyAddress address;
	
	public void setMyaddress(MyAddress myaddress) {
		this.address=myaddress;
	}
	
	public void prn() {
		System.out.println(address.toString());
	}

}
