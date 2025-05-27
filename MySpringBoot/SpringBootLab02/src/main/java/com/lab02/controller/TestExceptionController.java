package com.lab02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/test")
public class TestExceptionController {
	
	@GetMapping("/notfound")
	public String testEntityNotFound() {
		throw new EntityNotFoundException("엔티티 없음");
	}
	
	@GetMapping("/other")
	public String testException() throws Exception {
		throw new Exception("기타 등등 예외!");
	}
}
