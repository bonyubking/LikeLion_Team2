package com.lab01.controller;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.lab01.entity.Student;
import com.lab01.service.StudentService;

import java.util.List;

import lombok.RequiredArgsConstructor;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    // 학생 전체 조회 GET/students
//    @GetMapping
//    public List<Student> getAllStudents() {
//        return studentService.findAll();
//    }

    @GetMapping
    public CollectionModel<EntityModel<Student>> getAllStudents(){
        List<Student> students = studentService.findAll();

        List<EntityModel<Student>> studentModels = students.stream()
            .map(student->EntityModel.of(student,
                linkTo(methodOn(StudentController.class)
                    .getStudentById(student.getId())).withSelfRel(),
                linkTo(methodOn(StudentController.class)
                    .getAllStudents()).withRel("all-students")
            ))
            .toList();
        return CollectionModel.of(studentModels,
            linkTo(methodOn(StudentController.class).getAllStudents()).withSelfRel());
    }

    // 학생 생성 POST/students
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // 학생 상세 조회 GET/students/:id
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable Long id) {
//        return studentService.findById(id);
//    }

    @GetMapping("/{id}")
    public EntityModel<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return EntityModel.of(student,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class)
                .getStudentById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class)
                .getAllStudents()).withRel("students"));
    }


    //학생 정보 수정 PUT/students/:id
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student findStudent = studentService.findById(id); //ID 이용해 수정될 객체 조회
        findStudent.setGrade(student.getGrade());
        findStudent.setName(student.getName());

        return studentService.save(findStudent); // 수정된 내용 저장 후 리턴
    }

    //학생 삭제 DELETE/students/:id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }
}
