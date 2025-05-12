package com.workshop13.num04;

public abstract class Ship {
	
	private String shipName;
	private int fuelTank;
	
	public Ship(String shipName, int fuelTank) {
		this.shipName = shipName;
		this.fuelTank = fuelTank;
	}

	public Ship() {
		
	}
	
	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public int getFuelTank() {
		return fuelTank;
	}

	public void setFuelTank(int fuelTank) {
		this.fuelTank = fuelTank;
	}

	public abstract void sail(int dist);
	
	public abstract void refuel(int fuel);
	
}
