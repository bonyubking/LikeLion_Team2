package com.workshop10.num03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class Cafe {
	
    private List<Coffee> coffeeList = new ArrayList<>();
    private final int MAX_COFFEE = 3; // 최대 저장 가능 개수
	
	public Cafe() {
		
	}
	
	public void setCoffee(Coffee coffee) {
		if(coffeeList.size() >= MAX_COFFEE) {
			System.out.println("더 이상 저장 불가능.");
			return;
		}
		coffeeList.add(coffee);
	}
	
	public int totalPrice() {
		return coffeeList.stream().mapToInt(Coffee::getPrice).sum();
	}
	
	public List<Coffee> getcoffeeList(){
		return coffeeList;
	}
	
}
