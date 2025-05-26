package com.lab01;

import java.util.List;
import com.lab01.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Student save(Student student) {
		return studentRepository.saveAndFlush(student);
		//return studentRepository.save(student);
	}
	
	public Student findById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}

}
