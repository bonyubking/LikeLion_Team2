package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller //현재 클래스는 웹요청을 처리하는 controller
public class DemoController {

  //[1] GET 요청 : 폼화면 출력
  @GetMapping("/")
  public ModelAndView showForm(ModelAndView modelAndView){
    modelAndView.addObject("msg","숫자를 입력하시오");
    modelAndView.addObject("value","");
    modelAndView.setViewName("index");
    return modelAndView;
  }

  //[2] POST 요청 : 폼에서 받은 값 처리
  @PostMapping("/")
  //사용자가 html 폼에 입력한 숫자를 받아 합을 구하고 그 결과메세지를 html 전달해 화면 출력
  public ModelAndView handleForm(@RequestParam String text1, ModelAndView modelAndView){
    int sum = 0;
    for(int i=1;i<=Integer.parseInt(text1);i++){
      sum+=i;
    }
    modelAndView.addObject("msg","sum="+sum);
    modelAndView.addObject("value",text1);
    modelAndView.setViewName("index");
    return modelAndView;
  }


  @RequestMapping("/{num}") // "/"의 경로로 들어오는 요청을 처리함
  public ModelAndView home(@PathVariable int num, ModelAndView model){
    int sum=0;
    for(int i=1;i<=num;i++){
      sum+=i;
    }
    model.addObject("sum",sum); //데이터 담고
    model.setViewName("index"); //뷰이름 지정
    return model; // src/main/resources/templates/index.html 템플릿 뷰 찾아 렌더링
  }
}
