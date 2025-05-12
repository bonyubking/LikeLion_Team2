package com.workshop10.num03;

public class CafeTest {

	public static void main(String[] args) {
		Cafe cafelist = new Cafe();
		
        cafelist.setCoffee(new Coffee("Americano", 4000));
        cafelist.setCoffee(new Coffee("Caffelatte", 5000));
        cafelist.setCoffee(new Coffee("Macchiato", 6000));
        
        cafelist.getcoffeeList().forEach(System.out::println);
        
        System.out.printf("Coffee 가격의 합: %d", cafelist.totalPrice());

	}

}
