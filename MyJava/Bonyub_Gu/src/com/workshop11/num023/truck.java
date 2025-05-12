package com.workshop11.num023;

public class truck {
	
	private int max;
	private double tank;
	private double effi;
	private double currentOil;
	private int currentWeight;
	private double currentDistance;
	private int cost;
	
	public truck() {
		
	}
	
	public truck(int max, double tank, double effi) {
		super();
		this.max = max;
		this.tank = tank;
		this.effi = effi;
		this.currentOil = 0;
		this.currentDistance = 0;
		this.currentWeight = 0;
		this.cost = 0;
	}
	
	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}




	public double getTank() {
		return tank;
	}




	public void setTank(double tank) {
		this.tank = tank;
	}
	
	public double getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}
	



	public double getEffi() {
		return effi;
	}


	public void setEffi(int effi) {
		this.effi = effi;
	}
	
	
	public void SetOil(double amt) {
		this.currentOil += amt;
	}
	
	public void drive(double a1) {
		this.currentOil -= a1 / effi;
		this.cost += (a1 / effi) * 3000;
	}
	
	public void SetWeight(int wgt) {
		this.currentWeight += wgt;
		this.effi -= wgt / 25;
	}

	@Override
	public String toString() {
		
		return String.format("%d %.1f %.1f %d %.1f", max, tank, currentOil, currentWeight, effi);
		
	}
}
