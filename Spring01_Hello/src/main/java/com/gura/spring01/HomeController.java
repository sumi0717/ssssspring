package com.gura.spring01;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home.do") //.do는 생략 가능
	public String home(HttpServletRequest request) {
		
		List<String> news=new ArrayList<String>();
		news.add("안녕하세요");
		news.add("오늘 spring Framework 시작입니다");
		news.add("어쩌구");
		news.add("저쩌구");
		
		//request에 담기
		request.setAttribute("news", news);
		
		/*
		 *  view page의 정보를 문자열로 리턴하기
		 *  
		 *  prefix : /WEB-INF/views/
		 *  
		 *  suffix : .jsp
		 *  
		 *  "WEB-INF/views/"+"home"+".jsp"
		 *  
		 *  따라서 "/WEB-INF/views/home.jsp"로 사용 되어진다
		 *  
		 *  여기에 대한 설정 정보는
		 *  
		 *  WEB-INF/spring/appServlet/servlet-context.xml에 있다
		 */
		return "home";
	}
	
}