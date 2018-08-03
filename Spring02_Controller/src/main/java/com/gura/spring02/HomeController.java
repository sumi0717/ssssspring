package com.gura.spring02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//1. 클래스가 컨트롤러 역할을 할 수 있도록 
@Controller
public class HomeController {
	
	//2. 어떤 요청을 처리할 지 요청 맵핑
	@RequestMapping("/home") //어떤 경로로 시작할지 결정 "/home"은 value="home.do"와 같음
	public String home() {
		//3. 비지니스 로직 처리
		
		//4. view 페이지의 정보 리턴
		return "home"; // /WEB-INF/views/home.jsp 
					// prefix=/web-inf/views/ , suffix=.jsp 접두어 접미어 자동으로 붙음.
					// servelet-context.xml에 가면 설정정보 변경or확인 가능
	}
	
}
