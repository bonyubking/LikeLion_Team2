package com.student.service;

import java.util.List;

import com.student.dao.StudentDao;
import com.student.java.Student;

public class StudentServiceImple implements StudentService{
	
	private final StudentDao dao = new StudentDao();
	
	@Override
	public List<Student> selectAllstudent(){
		
		return dao.selectAllStudent();
		
	}

	@Override
	public int insertStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.insertStudent(s);
	}

	@Override
	public int deleteStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(s);
	}

	@Override
	public int updateStudent(Student s) {
		// TODO Auto-generated method stub
		return dao.updateStudent(s);
	}
}

