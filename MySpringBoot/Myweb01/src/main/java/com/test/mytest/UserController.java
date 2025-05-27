package com.test.mytest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.annotation.PostConstruct;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repos;
	
	//[1] 사용자 목록 + 홈페이지 (GET)
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute("formModel") User user, ModelAndView mav) {
		
		mav.setViewName("index");
		mav.addObject("data", repos.findAll());
		return mav;
	}
	
	//[2] 사용자 저장{POST)
	@RequestMapping(value="/", method = RequestMethod.POST)
	@Transactional(readOnly = false) // 현재 트랜잭션 내에서 쓰기작업 허용
	public ModelAndView index(@ModelAttribute("formModel") User user) {
		repos.saveAndFlush(user); // 사용자 데이터 입력받아 저장
		return new ModelAndView("redirect:/"); // 목록 화면으로 이동 -> 새로고침 했을떄 폼데이터 재전송 경고 뜨는껏방지
	} 
	
	
	//[3] 초기 사용자 등록
	@PostConstruct
	public void Init() {
		User user1 = new User();
		user1.setName("홍길동");
		repos.saveAndFlush(user1);
		
		User user2 = new User();
		user2.setName("정길동");
		repos.saveAndFlush(user2);
	}
}
