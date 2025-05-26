package com.lab01;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
public class StudentController {

	@Autowired
	private StudentService studentService;
	/*
	 * @GetMapping public List<Student> getAllStudents(){ return
	 * studentService.findAll(); }
	 * 
	 * @PostMapping("/{id}") public Student createStudent(@RequestBody Student
	 * student) { return studentService.save(student); }
	 * 
	 * // 학생상세 조회 GET //students/{id}
	 * 
	 * @GetMapping("/{id}") public Student getStudentById(@PathVariable Long id) {
	 * return studentService.findById(id); }
	 * 
	 * // 학생 정보 수정 PUT /students/{id}
	 * 
	 * @PutMapping("/{id}") public Student updateStudent(@PathVariable Long
	 * id, @RequestBody Student student) { Student res=studentService.findById(id);
	 * //수정될 ID로 객체를 찾아와서 res.setGrade(student.getGrade()); // 입력된 데이터를 담은 객체인
	 * student의 grade와 name으로 대입 res.setName(student.getName()); return
	 * studentService.save(res); // 수정된 내용을 저장 후 리턴 }
	 * 
	 * // 학생상세 삭제 Delete //students/{id}
	 * 
	 * @DeleteMapping("/{id}") public void deleteStudent(@PathVariable Long id) {
	 * studentService.delete(id); }
	 */

	@GetMapping
	public CollectionModel<EntityModel<Student>> getAllStudents() {
		List<Student> students = studentService.findAll();

		// 추가 코드
		List<EntityModel<Student>> studentModels = students.stream().map(student -> EntityModel.of(student,
				WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentById(student.getId()))
						.withSelfRel(),
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents())
						.withRel("all-students")))
				.collect(Collectors.toList());

		return CollectionModel.of(studentModels, WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents()).withSelfRel());
	}

	@GetMapping("/{id}")
	public EntityModel<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.findById(id);
		EntityModel<Student> resource = EntityModel.of(student);
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getStudentById(id))
				.withSelfRel());
		resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentController.class).getAllStudents())
				.withRel("all-students"));
		return resource;

	}

	// 학생 정보 수정 PUT /students/{id}
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		Student res = studentService.findById(id);
		res.setGrade(student.getGrade());
		res.setName(student.getName());
		return studentService.save(res);
	}

	// 학생상세 삭제 Delete //students/{id}
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.delete(id);
	}

}
