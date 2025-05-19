package com.sec03;

public class FruitService {
	
	private Fruit fruit;
	
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	
	public void printName() {
		System.out.println("Fruit : " + fruit.getName());
	}
}
