package com.labtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
  @GetMapping("/")
  public String home(){return "home";}
  @GetMapping("/user")
  public String user(){return "user";}
  @GetMapping("/login")
  public String login(){return "login";}
  @GetMapping("/admin")
  public String admin(){return "admin";}
  @GetMapping("/public")
  public String public_view(){return "public";}

}
