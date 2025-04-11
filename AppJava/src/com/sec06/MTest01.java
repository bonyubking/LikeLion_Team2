package com.sec06;


// public Person(String name, int age){}, name(), age()
record Person(String name, int age) {}
public class MTest01 {
	public static void main(String[] args) {
		//각각 Person 객체가 차례대로 메모리 할당받은 후
		//이 둘이 {}에 의해 0번지, 1번지로 묶임
		Person[] people = { 
				new Person("Alice", 30), 
				new Person("Bob", 25) };
		
		Person[] people02 = new Person[2];
		people02[0] = new Person("Alice",30);
		people02[1] = new Person("Bob",30);
		
		prn(people);
		prn(people02);

	}

	private static void prn(Person[] people) {
		for(Person res: people) {
			System.out.println(res); //res.toString()
		}
		System.out.println();
		
	}

}
