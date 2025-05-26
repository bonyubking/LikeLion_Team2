package com.lab01.controller;

import com.lab01.entity.Student;
import com.lab01.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  // 학생 전체 조회 GET/students
  @GetMapping
  public List<Student> getAllStudents(){
    return studentService.findAll();
  }

  // 학생 생성 POST/students
  @PostMapping
  public Student createStudent(@RequestBody Student student){
    return studentService.save(student);
  }

  // 학생 상세 조회 GET/students/:id
  @GetMapping("/{id}")
  public Student getStudentById(@PathVariable Long id){
    return studentService.findById(id);
  }

  //학생 정보 수정 PUT/students/:id
  @PutMapping("/{id}")
  public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
    return studentService.save(student);
  }

  //학생 삭제 DELETE/students/:id
  @DeleteMapping("/{id}")
  public void deleteStudent(@PathVariable Long id){
    studentService.delete(id);
  }
}
