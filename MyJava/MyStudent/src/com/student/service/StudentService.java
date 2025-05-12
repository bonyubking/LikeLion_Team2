package com.student.service;


import java.util.List;

import com.student.java.Student;

public interface StudentService {
	
	
	List<Student> selectAllstudent();
	int insertStudent(Student s);
	int deleteStudent(Student s);
	int updateStudent(Student s);

}
