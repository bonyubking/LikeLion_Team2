package com.workshop7.num06;

public abstract class Plane {
		
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		
	}

	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	
	public void refuel(int fuel) {
		
		this.setFuelSize(this.getFuelSize()+fuel);
	}
	
	@Override
	public String toString() {
		
		return String.format("%5s %10d", getPlaneName(), getFuelSize());
	}

	
	

	public abstract void flight(int distance);
	
	
}
