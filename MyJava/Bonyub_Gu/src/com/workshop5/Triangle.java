package com.workshop5;

public class Triangle extends Shape implements Resize {
	
	public Triangle() {
		super();

	}

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);

	}

	@Override
	public void setResize(int size) {
		
		this.setHeight(this.getHeight()+size);

	}

	@Override
	public double getArea() {

		return (this.getWidth() * this.getHeight()) / 2.0;
	}


	
	
	
}
