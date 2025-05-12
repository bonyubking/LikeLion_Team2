package com.sec13.myio;

import java.io.Serializable;

public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7555594727281047425L;
	private String name;
	public static int age; // 직렬화 대신 아님
	private int height;
	private transient int weight; // 직렬화 대상아님

	public Student() {
		super();		
	}

	public Student(String name, int age, int height, int weight) {
		this.name = name;
		Student.age = age;
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
}
