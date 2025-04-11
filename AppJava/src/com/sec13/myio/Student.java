package com.sec13.myio;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Student implements Serializable{ //해당클래스를 바이트 스트림으로 변환하겠다. -> 직렬화 
	
	private String name; //static 변수 초기값
	private int age;
	private int height;
	private int weight;

	public Student() {
		super();
	}

	public Student(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public String studentInfo() {
		return 
				String.format( "%10s  %5d  %5d %5d \n", this.getName(), this.getAge(), this.getHeight(), this.getWeight());
	}
	
	public String toString() {
		return this.studentInfo();
	}
}