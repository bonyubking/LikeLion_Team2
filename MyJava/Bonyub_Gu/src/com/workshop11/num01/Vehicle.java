package com.workshop11.num01;

public class Vehicle {
	
	private int maxWeight;
	private double oilTankSize;
	protected double efficiency;
	
	public Vehicle() {
		
	}
	
	
	
	public int getMaxWeight() {
		return maxWeight;
	}



	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}



	public double getOilTankSize() {
		return oilTankSize;
	}



	public void setOilTankSize(double oilTankSize) {
		this.oilTankSize = oilTankSize;
	}



	public double getEfficiency() {
		return efficiency;
	}



	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}



	public Vehicle(int maxWeight, double oilTankSize, double efficiency) {
		super();
		this.maxWeight = maxWeight;
		this.oilTankSize = oilTankSize;
		this.efficiency = efficiency;
	}
	
	@Override
	public String toString() {
		return String.format("%d %5.1f", this.maxWeight , this.oilTankSize);
		
	}


	
}
