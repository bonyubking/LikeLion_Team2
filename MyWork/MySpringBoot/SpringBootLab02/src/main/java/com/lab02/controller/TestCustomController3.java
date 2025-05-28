package com.lab02.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestCustomController3 implements ErrorController{

	// (2) 엔티티를 찾지 못했을 때 처리
	@RequestMapping("/error")
	public String testEntitynotFound(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Object msr = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
		model.addAttribute("status",status);
		model.addAttribute("msr",msr);
		return "custom-error";
	}

	
}
