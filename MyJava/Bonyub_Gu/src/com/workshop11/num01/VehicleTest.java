package com.workshop11.num01;

import java.util.List;

public class VehicleTest {


	public static void main(String[] args) {
		
		Truck truck = new Truck(1000, 100.0, 5.0);
		System.out.println("최대적재중량  오일탱크크기  잔여오일량  현재적재중량  연비");
		System.out.println(truck);
		truck.addOil(50);
		System.out.println("50L 주행 후");
		System.out.println(truck);
		truck.moving(50);
		System.out.println("50km 주행후");
		System.out.println(truck);
		truck.addWeight(100);
		System.out.println("100kg 적재후");
		System.out.println(truck);
		truck.moving(30);
		System.out.println("30km 주행후");
		System.out.println(truck);
		System.out.printf("100kg 탑재하고 30km 주행시 요금 : %d 원\n ",truck.getCost(30));
		
		
		
		
        List<Integer> distanceList = List.of(30, 30, 50);
        int totalCost = distanceList.stream()
                                    .mapToInt(truck::getCost)
                                    .sum();

        System.out.println("문제 3-3 적용");
        System.out.println("총 요금: " + totalCost + "원");
		
	}

}
