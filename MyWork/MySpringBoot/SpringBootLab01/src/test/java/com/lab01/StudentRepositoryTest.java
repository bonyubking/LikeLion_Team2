package com.lab01;

import com.lab01.Student;
import com.lab01.StudentRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test 
    @DisplayName("MyTest👽")
    public void testSaveStudent() { 
        Student student = new Student(); 
        student.setName("John"); 
        student.setGrade(2); 
 
        Student savedStudent = studentRepository.save(student); 
 
        assertThat(savedStudent.getId()).isNotNull(); 
        assertThat(savedStudent.getName()).isEqualTo("John"); 
    }
    
    @Test
    public void testMy() {
    	
    }
}
