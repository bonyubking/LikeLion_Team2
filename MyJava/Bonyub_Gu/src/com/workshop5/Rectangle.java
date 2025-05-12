package com.workshop5;

public class Rectangle extends Shape implements Resize {

	@Override
	public void setResize(int size) {
		
		this.setWidth(this.getWidth()+size);


	}

	@Override
	public double getArea() {

		return (this.getWidth() * this.getHeight());
	}

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}

	
	
}
