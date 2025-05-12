package com.workshop9.num02;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import static java.util.Comparator.comparingInt;

class Student2 {
	private String name;
	private int age;
	private int height;
	private int weight;

	public Student2(String name, int age, int height, int weight) {
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

	public void studentInfo() {
		System.out.println(name + "\t" + age + "\t" + height + "\t" + weight);
	}
}

public class StudentTest2 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(new Student("홍길동", 15, 170, 80), new Student("한사람", 13, 180, 70),
				new Student("이순신", 16, 175, 65));

		System.out.println("이름\t나이\t신장\t몸무게");

		for (Student student : students) {
			student.studentinfo();
		}

		////////////////////////////////////////////////////////
		
		OptionalDouble averageAge = students.stream().mapToInt(Student::getAge).average();
		OptionalDouble averageHeight = students.stream().mapToInt(Student::getHeight).average();
		OptionalDouble averageWeight = students.stream().mapToInt(Student::getWeight).average();

		System.out.printf("\n\n나이 평균: %.3f\n", averageAge.orElse(0));
		System.out.printf("신장 평균: %.3f\n", averageHeight.orElse(0));
		System.out.printf("몸무게 평균: %.3f\n", averageWeight.orElse(0));

		//////////////////////////////////////////////////////// 
		Student youngestStudent = students.stream().min(comparingInt(Student::getAge)).orElse(null);
		Student oldestStudent = students.stream().max((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
				.orElse(null);

		System.out.println("\n\n나이가 가장 많은 학생: " + oldestStudent.getName());
		System.out.println("나이가 가장 적은 학생: " + youngestStudent.getName());

		//////////////////////////////////////////////////////////////////
		Student shortestStudent = students.stream().min(comparingInt(Student::getHeight)).orElse(null);
		Student tallestStudent = students.stream().max(comparingInt(Student::getHeight)).orElse(null);

		System.out.println("신장이 가장 큰 학생: " + tallestStudent.getName());
		System.out.println("신장이 가장 작은 학생: " + shortestStudent.getName());

		//////////////////////////////////////////////////////////////////
		Student lightestStudent = students.stream().min(comparingInt(Student::getWeight)).orElse(null);
		Student heaviestStudent = students.stream().max(comparingInt(Student::getWeight)).orElse(null);

		System.out.println("몸무게가 가장 많이 나가는 학생: " + heaviestStudent.getName());
		System.out.println("몸무게가 가장 적게 나가는 학생: " + lightestStudent.getName());
	}
}
