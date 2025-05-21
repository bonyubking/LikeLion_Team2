package com.sec03;

public class FruitService {
	private Fruit fruit; // 인터페이스 추상 선언

	public void setFruit(Fruit fruit) { //setter 주입
		this.fruit = fruit;
	}

	public void printName() {
		System.out.println("Fruit" + fruit.getName());
	}
}
