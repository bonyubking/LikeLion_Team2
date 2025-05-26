package com.lab01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lab01.entity.Student;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc //springboot mvc 테스트 시도
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL) //테스트 클래스의 생성자 기반 DI 도와줌
public class StudentControllerTest {
    private final MockMvc mockMvc;
    // JSON 형태 변환용
    private final ObjectMapper mapper;
    private Student student;

    @Autowired
    public StudentControllerTest(MockMvc mockMvc, ObjectMapper mapper) {
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    // 테스트 이전에 하나의 레코드 삽입
    @BeforeEach
    void setUp(){
        student = new Student();
        student.setGrade(6);
        student.setName("8888");
    }

    /*
    * 1) 학생 등록 테스트
    * POST /students
    * */
    @Test
    void createStudent() throws Exception{
        String newStudentJson = "{ \"name\": \"홍길동\", \"grade\":1 }";
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(student)))
                .content(newStudentJson))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").value("홍길동"))
            .andExpect(jsonPath("$.grade").value(1));
    }

    /*
    * 2) 학생 목록 테스트
    * */
    @Test
    void getAll()throws Exception{
        mockMvc.perform(get("/students"))
            .andExpect(status().isOk());
    }
}
