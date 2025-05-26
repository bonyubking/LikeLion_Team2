package com.lab01.service;

import com.lab01.entity.Student;
import com.lab01.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

  private final StudentRepository studentRepository;

  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Transactional
  public Student save(Student student) {
    return studentRepository.save(student);
  }

  public Student findById(Long id) {
    return studentRepository.findById(id).orElse(null);
  }

  @Transactional
  public void delete(Long id) {
    Student student = findById(id);
    studentRepository.delete(student);
  }

}
