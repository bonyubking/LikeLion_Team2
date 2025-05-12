package com.student.java;

public class Student {
	
	private String id; 
	private String sname;
	private String major;
	private String grade;
	
	public Student() {
		
	}
	
	
	public Student(String id, String sname, String major, String grade) {
		super();
		this.id = id;
		this.sname = sname;
		this.major = major;
		this.grade = grade;
	}


	public String getId() {
		return id;
	}
	public void setId(String string) {
		this.id = string;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
