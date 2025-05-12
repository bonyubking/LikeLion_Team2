package com.workshop7.num06;

public class Cargoplane extends Plane {
	
	public Cargoplane(){
		super();
	}
	
	public Cargoplane(String planeName, int fuelsize) {
		super(planeName, fuelsize);

	}
	
	
	@Override
	public void flight(int distance) {
		
		this.setFuelSize(this.getFuelSize()-distance*5);
	}

}
