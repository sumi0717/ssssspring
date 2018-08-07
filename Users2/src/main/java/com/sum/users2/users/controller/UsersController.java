package com.sum.users2.users.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sum.users2.users.dto.UsersDto;
import com.sum.users2.users.service.UsersService;



@Controller
public class UsersController {
	@Autowired
	private UsersService mService;
	
	//회원 수정 요청 처리
	@RequestMapping("/users/update")
	public String update(@ModelAttribute UsersDto dto) {
		mService.update(dto);
		return "redirect:/users/list.do";
	}
	
	
	//회원 수정 폼 요청 처리
	@RequestMapping("/users/updateform")
	public ModelAndView updateForm(@RequestParam int num) {
		ModelAndView mView=new ModelAndView();
		mService.getData(mView, num);
		mView.setViewName("users/updateform");
		return mView;
	}
	
	//회원 삭제 요청 처리
	@RequestMapping("/users/delete")
	public String delete(@RequestParam int num) {
		mService.delete(num);
		return "redirect:/users/list.do";
	}
	

	@RequestMapping("/users/insert")
	public String insert(@ModelAttribute UsersDto dto) {
						//Dto의 필드명하고 전달되는 파라미터 명하고 똑같아야함
	/*
	 *  회원정보가 담긴 MemberDto 객체를 MemberService
	 *  객체를 이용해서 DB에 저장하기  
	 */
		mService.insert(dto);
		
		return "users/insert"; 
		//리다이렉트 안하고, 이렇게 포워드 처리하면 view 페이지에 insert.jsp 만들어야함
		
	}
	
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/users/insertform")
	public String insertForm() {
		return "users/insertform";
	}
	
	//회원 목록 요청 처리
	@RequestMapping("/users/list")
	public ModelAndView list() {
		
		
		//보통 컨트롤러에서는 비지니스 로직 수행하지 않음. 최소한의 로직만 수행해야!
//컨트롤러에서는 어떤 경로 이동에 대해서, 무슨 처리를 하고, 어디로 이동하는지가 핵심!
//컨트롤러에서 Dao에 의존하지 않고, 서비스에 의존해야 함
				
		ModelAndView mView=new ModelAndView();
		//MemberService 객체를 이용해서 비지니스 로직 처리하고
		mService.list(mView);//view 페이지에 필요한 데이터는 list 메소드 안에 넣어줌

		// 뷰 페이지 정보 설정
		// /WEB-INF/views/member/list.jsp랑 같음. prefix, suffix 자동으로 붙는것
		mView.setViewName("users/list");
		
		return mView;
	}
	


}
