package com.student.view;

import java.util.List;

import com.student.java.Student;

public class StudentConsolView {
	
	public void showAllList(List<Student> list) {
		for (Student s : list) {
			System.out.println(s.getId() + "\t" + s.getSname() + "\t" + s.getGrade() + "\t" + s.getMajor());
		}
	}
	
	public void showMessage(String message) {
		System.out.println("[알림]" + message);
	}
}
