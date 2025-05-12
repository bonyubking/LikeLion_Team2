package com.workshop13.num08;

public abstract class Shape implements Movable {
	
	private Point point;

	public Shape(Point point) {

		this.point = point;
	}
	
	public Shape() {
		
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public abstract double getArea();
	
	public abstract double getCircumference();

}
