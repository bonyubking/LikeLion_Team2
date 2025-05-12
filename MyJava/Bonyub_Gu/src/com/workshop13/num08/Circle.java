package com.workshop13.num08;

public class Circle extends Shape implements Movable{
	
	private int radius;
	
	public Circle(int radius, int x, int y) {
		
		super(new Point(x, y));
		this.radius = radius;

	}

	public Circle() {
        
    }
	
	

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		
        return Math.PI * radius * radius;
	}

	@Override
	public double getCircumference() {

		return Math.PI * radius * 2;
	}

	@Override
	public void move(int dx, int dy) {
	    
		Point p = getPoint();  
	    
		p.setX(p.getX() + dx + 1);
	    p.setY(p.getY() + dy + 1);

	}

}
