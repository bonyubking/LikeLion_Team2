package com.sec06;


record Person(String name, int age) {}
public class MTest01 {

	public static void main(String[] args) {
		Person[] people = {new Person("Alice", 30),
							new Person("Bob", 25) };
		
		Person[] people02 = new Person[2];
		people02[0] = new Person("Alice", 30);
		people02[1] = new Person("Bob", 25);
 		System.out.println(people);
 		
 		prn(people);
 		prn(people02);
	
	}
	
	
	private static void prn(Person[] people) {
		for (Person res: people) {
			System.out.println(res);
		}
	}
}
