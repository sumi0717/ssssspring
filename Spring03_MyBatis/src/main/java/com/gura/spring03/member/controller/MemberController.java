package com.gura.spring03.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;
import com.gura.spring03.member.service.MemberService;

@Controller //원랜 service를 통해서 코딩해야되는데 임시로 Dao 이용
public class MemberController {
	//의존 객체
	@Autowired
	private MemberService mService;
	
	//회원 수정 요청 처리
	@RequestMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto) {
		mService.update(dto);
		return "redirect:/member/list.do";
	}
	
	
	//회원 수정 폼 요청 처리
	@RequestMapping("/member/updateform")
	public ModelAndView updateForm(@RequestParam int num) {
		ModelAndView mView=new ModelAndView();
		mService.getData(mView, num);
		mView.setViewName("member/updateform");
		return mView;
	}
	
	//회원 삭제 요청 처리
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		mService.delete(num);
		return "redirect:/member/list.do";
	}
	
	
	//회원 추가 요청 처리
	//1번쨰 방법
//	@RequestMapping("/member/insert")
//	public String insert(HttpServletRequest request) {
//		String name=request.getParameter("name");
//		String addr=request.getParameter("addr");
//		MemberDto dto=new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr);
//		
//		mService.insert(dto);
//		
//		return "redirect:/member/list.do";
//	}
	
	
	
	//2번째 방법 getParameter 할 필요 없이, 바로 파라미터를 인자로 전달받아서 모델 넣음.
//	@RequestMapping("/member/insert")
//	public String insert(@RequestParam String name, @RequestParam String addr) {
//		=> 이 방법은 파라미터 하나하나 추출하는 것.
//	
//		MemberDto dto=new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr);
//		
//		mService.insert(dto);
//		
//		return "redirect:/member/list.do";
//	}
	
	
	
//	(HttpServletRequest request) {
//	String name=request.getParameter("name");
//	String addr=request.getParameter("addr");
//	MemberDto dto=new MemberDto();
//	dto.setName(name);
//	dto.setAddr(addr);  이 작업을 => @ModelAttribute MeberDto dto가 대신 해줌!!!!
// => 이 방법은 파라미터로 전달된 dto 통째로 빼내는 것.
	//3번째 방법.
	@RequestMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto) {
						//Dto의 필드명하고 전달되는 파라미터 명하고 똑같아야함
	/*
	 *  회원정보가 담긴 MemberDto 객체를 MemberService
	 *  객체를 이용해서 DB에 저장하기  
	 */
		mService.insert(dto);
		
		return "member/insert"; 
		//리다이렉트 안하고, 이렇게 포워드 처리하면 view 페이지에 insert.jsp 만들어야함
		
	}
	
	
	//회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertForm() {
		return "member/insertform";
	}
	
	//회원 목록 요청 처리
	@RequestMapping("/member/list")
	public ModelAndView list() {
		
		
		//보통 컨트롤러에서는 비지니스 로직 수행하지 않음. 최소한의 로직만 수행해야!
//컨트롤러에서는 어떤 경로 이동에 대해서, 무슨 처리를 하고, 어디로 이동하는지가 핵심!
//컨트롤러에서 Dao에 의존하지 않고, 서비스에 의존해야 함
				
		ModelAndView mView=new ModelAndView();
		//MemberService 객체를 이용해서 비지니스 로직 처리하고
		mService.list(mView);//view 페이지에 필요한 데이터는 list 메소드 안에 넣어줌

		// 뷰 페이지 정보 설정
		// /WEB-INF/views/member/list.jsp랑 같음. prefix, suffix 자동으로 붙는것
		mView.setViewName("member/list");
		
		return mView;
	}
}
