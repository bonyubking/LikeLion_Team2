package com.lab02.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@Controller
public class TestExceptionController03 implements ErrorController {

  @RequestMapping("/error")
  public String testEntityNotFound(HttpServletRequest request, Model model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    Object msr = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
    model.addAttribute("status", status);
    model.addAttribute("msr", msr);
    return "custom-error";
  }
}

