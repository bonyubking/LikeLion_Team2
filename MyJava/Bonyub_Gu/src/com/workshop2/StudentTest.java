package com.workshop2;
import java.util.ArrayList;
import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		
		Student a1 = new Student();
		Student a2 = new Student();
		Student a3 = new Student();
		
		a1.setName("민들래");
		a1.setAge(15);
		a1.setHeight(170);
		a1.setWeight(55);
		a2.setName("개나리");
		a2.setAge(22);
		a2.setHeight(165);
		a2.setWeight(53);
		a3.setName("개나리");
		a3.setAge(20);
		a3.setHeight(155);
		a3.setWeight(46);
		
		

		
		
		System.out.println(a1);
		
		StudentView view = new StudentView();
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(a1);
		studentList.add(a2);
		studentList.add(a3);
		
		view.viewStudentList(studentList);

	}

}


class Student{
	
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("%s %10d %10d %10d", getName(), getAge(), getHeight(), getWeight());
	}
}

class StudentView{
	
	public void viewStudent(Student st){
		System.out.println(st);
		
	}
	
	public void viewStudentList(List<Student> list) {
		list.forEach(System.out::println);
	}
	

}
