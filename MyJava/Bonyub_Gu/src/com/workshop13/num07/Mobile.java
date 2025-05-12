package com.workshop13.num07;

public class Mobile {
	
	private String code;
	private String name;
	private double price;
	
	public Mobile(String code, String name, double price) {
		
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public Mobile() {
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String printInfo() {
		
		return code + "  " + name + "  " + String.format("%.1f", price);
	
	}

}
