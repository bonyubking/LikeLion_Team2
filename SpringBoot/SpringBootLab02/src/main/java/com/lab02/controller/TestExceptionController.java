package com.lab02.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1a")
public class TestExceptionController {

  //(1) 유효성 검증 실패 처리


  //(2) 엔티티 찾지 못했을 때 처리
  @GetMapping("/notfound")
  public String testEntityNotFound(){
    throw new EntityNotFoundException("엔티티 찾을 수 없음");
  }

  //(3) 그 외의 예외 처리
  @GetMapping("/other")
  public String testException() throws Exception{
    throw new Exception("기타 예외");
  }
}
