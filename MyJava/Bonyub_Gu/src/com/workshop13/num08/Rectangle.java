package com.workshop13.num08;

public class Rectangle extends Shape implements Movable{

	private int width;
	
	public Rectangle(int width, int x, int y) {
		
		super(new Point(x, y));
		this.width = width;
	}
	
	public Rectangle() {

	}
	
	@Override
	public double getArea() {

		return width * width;
	}

	@Override
	public double getCircumference() {

		return width*4;
	}
	
	@Override
	public void move(int dx, int dy) {
	    
		Point p = getPoint();  
	    
		p.setX(p.getX() + dx + 2);
	    p.setY(p.getY() + dy + 2);

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	

}
