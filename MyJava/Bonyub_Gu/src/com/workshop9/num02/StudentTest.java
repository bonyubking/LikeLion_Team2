package com.workshop9.num02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.IntStream;


public class StudentTest {
	public static void main(String[] args) {
		
		Student a1 = new Student("홍길동",15,170,80);
		Student a2 = new Student("한사람",13,180,70);
		Student a3 = new Student("이순신",16,175,65);
		
		Student[] lst = new Student[3];
		lst[0] = a1;
		lst[1] = a2;
		lst[2] = a3;
		
		System.out.printf("%s %5s %5s %5s\n", "이름", "나이", "신장", "몸무게");
		
		for (Student key: lst) {
			System.out.printf(key.studentinfo()+"\n");
		}
		
		double avgAge = Arrays.stream(lst).mapToInt(Student::getAge).average().orElse(0);
		System.out.printf("평균 나이: %.3f\n " , avgAge);
		
		double avgHgt = Arrays.stream(lst).mapToInt(Student::getHeight).average().orElse(0);
		System.out.printf("평균 신장: %.3f\n " , avgHgt);
		
		double avgWgt = Arrays.stream(lst).mapToInt(Student::getWeight).average().orElse(0);
		System.out.printf("평균 몸무게: %.3f\n " , avgWgt);
		
		Optional<Student> maxAge = Arrays.stream(lst).max(Comparator.comparingInt(Student::getAge));
		maxAge.ifPresent(student -> System.out.printf("나이가 가장 많은 학생 : %s\n", student.getName()));
		
		Optional<Student> minAge = Arrays.stream(lst).min(Comparator.comparingInt(Student::getAge));
		minAge.ifPresent(student -> System.out.printf("나이가 가장 적은 학생 : %s\n", student.getName()));
		
		Optional<Student> maxHgt = Arrays.stream(lst).max(Comparator.comparingInt(Student::getWeight));
		maxHgt.ifPresent(student -> System.out.printf("무게가 가장 무거운 학생 : %s\n", student.getName()));
		
		Optional<Student> minHgt = Arrays.stream(lst).min(Comparator.comparingInt(Student::getWeight));
		minHgt.ifPresent(student -> System.out.printf("무게가 가장 가벼운 학생 : %s\n", student.getName()));
		
		Optional<Student> maxWgt = Arrays.stream(lst).max(Comparator.comparingInt(Student::getHeight));
		maxWgt.ifPresent(student -> System.out.printf("키가 가장 큰 학생 : %s\n", student.getName()));
		
		Optional<Student> minWgt = Arrays.stream(lst).min(Comparator.comparingInt(Student::getHeight));
		minWgt.ifPresent(student -> System.out.printf("키가 가장 작은 학생 : %s\n", student.getName()));
	}

}
