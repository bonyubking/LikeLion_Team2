package com.workshop13.num04;

public class Boat extends Ship {

	public Boat() {
		
	}

	public Boat(String shipName, int fuelTank) {
		super(shipName, fuelTank);

	}

	@Override
	public void sail(int dist) {
		
		setFuelTank(getFuelTank() - dist*10);
	}

	@Override
	public void refuel(int fuel) {
		
		setFuelTank(getFuelTank() + fuel*10);
	}
	
}
