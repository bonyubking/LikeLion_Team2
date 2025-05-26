package com.lab01.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.is;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab01.SpringBootLab01Application;
import com.lab01.Student;

@SpringBootTest(classes = SpringBootLab01Application.class)
@AutoConfigureMockMvc //springBoot MVC를 테스트 하겠다 
public class StudentControllerTest {
   
	@Autowired
	MockMvc mockMvc;
	
	//Json 형태 변환용 
	@Autowired
	private ObjectMapper mapper;
	
	private Student student;
	
	// 테스트 이전에 하나의 레코드를 인서트 해보자 
	@BeforeEach
	void setUp() {
		student=new Student();
		student.setName("8888");
	}
	/* 1) 학생 등록 테스트
	 *   (POST / students) 
	 */
	@Test
	void createStudent()throws Exception{
		/* mockMvc.perform(post("/students")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(mapper.writeValueAsString(student)))
				 .andExpect(status().isOk()) // 201 Created, isOk() 200 ok
				 .andExpect(jsonPath("$.name",is("8888")))
				 .andExpect(jsonPath("$.grade",is(1)));
			*/ 
		String newStudentJson= "{\"name\":\"홍길동\".\"grade\":\"1\"}";
		mockMvc.perform(post("/students")
				 .contentType(MediaType.APPLICATION_JSON)
				 .content(newStudentJson))
				 .andExpect(status().isCreated()) // 201 Created, isOk() 200 ok
				 .andExpect(jsonPath("$.name").value("홍길동"))
				 .andExpect(jsonPath("$.grade").value(1));
	}
	
	/* 2) 학생 목록 테스트
	 *  
	 */
	@Test
	void getAll()throws Exception{
		mockMvc.perform(get("/students"))
		.andExpect(status().isOk());
	}
}
