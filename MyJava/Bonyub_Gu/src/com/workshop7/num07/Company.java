package com.workshop7.num07;

import java.util.HashMap;

public class Company {

	public static void main(String[] args) {
		
		HashMap<Integer, Employee> map = new HashMap<>();
		
		Employee a1 = new Secretary("Hilery",1,"secretary",800);
		Employee a2 = new Sales("Clinten",2,"sales",1200);
		
		map.put(a1.getNumber(), a1);
		map.put(a2.getNumber(), a2);
		
		System.out.println("name  department     salary");
		System.out.println("===========================");
		
		for (Employee arr : map.values()) {
			System.out.printf("%s %10s %5d\n",arr.getName(),arr.getDepartment(),arr.getSalary());
		}
		
		
		System.out.println("인센티브 100 지급");
		System.out.println("name  department     salary      tax");
		System.out.println("=====================================");
		
		for (Employee arr: map.values()) {
			
			arr.incentive(100);
			System.out.printf("%s %10s %5d %5.1f\n",arr.getName(),arr.getDepartment(),arr.getSalary(),arr.tax());

		}
		

	}

}
