package com.workshop7.num06;

public class Airplane extends Plane {
	
	public Airplane(){
		super();
	}
	
	public Airplane(String planeName, int fuelsize) {
		super(planeName, fuelsize);

	}
	
	
	@Override
	public void flight(int distance) {
		
		this.setFuelSize(this.getFuelSize()-distance*3);
	}


}
