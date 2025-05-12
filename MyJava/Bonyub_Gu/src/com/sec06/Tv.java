package com.sec06;

class Tv {
	private String name;
	private int price;
	private String descript;
	
	// needed when there is a constructor
	public Tv() {};
	
	// Constructor
	public Tv(String name, int price, String descript) {
		this.name = name;
		this.price = price;
		this.descript = descript;
	}
	


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}



	/**
	 * @return the descript
	 */
	public String getDescript() {
		return descript;
	}



	/**
	 * @param descript the descript to set
	 */
	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	@Override
	public String toString() {
		return String.format("%-10s %-10d %-10s", name, price, descript);
	}
}

