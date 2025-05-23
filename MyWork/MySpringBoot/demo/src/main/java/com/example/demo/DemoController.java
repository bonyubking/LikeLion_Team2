package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller // 현재 클래스는 웹 요청을 처리하는 컨트롤러 
public class DemoController {
	
	// [1] GET 요청 : 폼화면 출력
	@GetMapping("/")
	public ModelAndView showForm(ModelAndView mav) {
		mav.addObject("msg","숫자를 입력하시오");
		mav.addObject("value","");
		mav.setViewName("index");
		return mav;
	}
	
	// [2]POST 요청 : 폼에서 받은 값 처리
	// 사용자가 html 폼에 입력한 숫자를 받아 합을 구하고 그 결과메시지를 html 전달 화면 출력 
	@PostMapping("/")  //<form method="post" action="/">
	ModelAndView handleForm(@RequestParam String text1,ModelAndView model) {
		int sum = 0;
		int num = Integer.parseInt(text1);
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		model.addObject("msg", "sum="+sum); //데이터 담고
		model.addObject("value",text1);
		model.setViewName("index"); //뷰이름 저장
		return model; 
	}
	
	
	// [3]URL 직접 입력 방식 테스트
	@RequestMapping("/{num}") // 지정된 숫자의 합을 구해서 index로 보내자
	ModelAndView index(@PathVariable int num,ModelAndView model) {
		int sum=0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		model.addObject("msg", "sum="+sum); //데이터 담고
		model.setViewName("index"); //뷰이름 저장
		return model; 
	}
	
	
	/*@RequestMapping("/{num}") // 지정된 숫자의 합을 구해서 index로 보내자
	String index(@PathVariable int num,Model model) {
		int sum=0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		model.addAttribute("msg", "sum="+sum); //msg= "sum="+sum
		return "index"; 
	}*/

}
