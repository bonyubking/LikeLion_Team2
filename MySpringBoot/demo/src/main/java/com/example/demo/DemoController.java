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

@Controller
public class DemoController {
	
	@GetMapping("/")
	public ModelAndView showform(ModelAndView mav) {
		mav.addObject("msg", "숫자 입력칸");
		mav.addObject("value", "");
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/")
	ModelAndView handleform(@RequestParam String text1, ModelAndView model) {
		int sum =0;
		int num = Integer.parseInt(text1);
		
		for(int i = 1 ; i <= num ; i ++) {
			sum += i;
		}
		
		model.addObject("msg", "sum=" + sum);
		model.addObject("value",text1);
		model.setViewName("index");
		return model; // index.html 템플릿 뷰를 렌더링
	}
	
	
	@RequestMapping("/{num}") // 지정된 숫자의 합을 구해서 index로 전송
	ModelAndView index(@PathVariable int num, ModelAndView model) {
		int sum =0;
		for(int i = 1 ; i <= num ; i ++) {
			sum += i;
		}
		
		model.addObject("msg", "sum=" + sum);
		model.setViewName("index");
		return model; // index.html 템플릿 뷰를 렌더링
	}
	
	/*@RequestMapping("/{num}") // 지정된 숫자의 합을 구해서 index로 전송
	String index(@PathVariable int num, Model model) {
		int sum =0;
		for(int i = 1 ; i <= num ; i ++) {
			sum += i;
		}
		
		model.addAttribute("msg", "sum=" + sum);
		return "index"; // index.html 템플릿 뷰를 렌더링
	}*/
}
