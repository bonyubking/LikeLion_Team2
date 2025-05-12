package com.workshop10.num03;

public class Coffee {
	
	private String name;
	private int price;
	
	public Coffee() {
		
	}
	
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + "    " + price;
	}
	
	
}
