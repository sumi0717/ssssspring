package com.gura.spring02;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/fortune")
	public String showFortune(HttpServletRequest request) {
		//view 페이지에 전달할 Model
		String fortuneToday="동쪽으로 가면 어쩌구 입니다";
		//request에 담기
		request.setAttribute("fortuneToday",fortuneToday);
		return "fortune";
	}
	
	@RequestMapping("/person")
	public ModelAndView showPerson(HttpServletRequest request) {
		
		String showP="오늘의 인물입니다";
		
		//모델과 뷰 페이지 객체를 담을 수 있는 메소드
		//리퀘스트에 셋 어트리뷰트 담을 것을, 모델앤 뷰로, add해서 담음
		//request에 담을 Model과 view 페이지 정보를 가지는 객체
		ModelAndView mView=new ModelAndView();
		mView.addObject("showP",showP);
		mView.setViewName("person");
		
		return mView;
	}
}
