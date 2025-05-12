package com.student.dao;

import java.util.List;

import com.student.java.Student;


public interface StudentDaoImple {
	
	String insert_sql="insert into student(id, sname, major, grade) values (?,?,?,?)";
	String update_sql="update student set id = ?, major=?, grade=? where sname=? ";
	String delete_sql="delete from student where sname=?";
	String select_sql="select id, sname, major, grade from student";


	public int deleteStudent(Student s);
	public int insertStudent(Student s);
	public int updateStudent(Student s);
	public List<Student> selectAllStudent();

	
}
