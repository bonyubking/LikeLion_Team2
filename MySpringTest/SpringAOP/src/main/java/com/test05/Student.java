package com.test05;

public class Student implements Person, Person2 {
	
	public Student() {
		System.out.println("기본생서자");
	}

	@Override
	public void classWork() {
		
		System.out.println("[학생] classwork");

	}

	@Override
	public void homeWork() {
		System.out.println("[학생] homework");

	}

	@Override
	public void meeting(String topic) {
		
		System.out.println("[학생] meeting "  + topic);


	}
	
	@Override
	public void study() {
		
		System.out.println("[학생] study");
	}
	
	@Override
	public void relax() {
		
		System.out.println("[학생] relax");

	}
	
	@Override
	public void eat(String food) {
		
		System.out.println("[학생] eat " + food);

	}
	
	@Override
	public int getScore() {
		
		System.out.println("[학생] getScore ... ");

		return 100;
	}

}
