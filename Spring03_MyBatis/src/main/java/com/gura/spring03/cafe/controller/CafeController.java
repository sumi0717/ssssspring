package com.gura.spring03.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.dto.CafeDto;
import com.gura.spring03.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/cafe/list")
	public ModelAndView list(HttpServletRequest request) {
		//인자로 전달받은 HttpServletRequest 객체를 서비스에 전달해서,
		//비지니스 로직을 수행하고
		//view 페이지에서 필요한 데이터가 request 영역에 담기게 한다
		cafeService.getList(request);
		//view 페이지로 forward 이동
		return new ModelAndView("cafe/list");
	}
	
	//새글 저장 요청 처리
	@RequestMapping("/cafe/insert")
	public ModelAndView authinsert(HttpServletRequest request) {
		//서비스 객체를 이용해서 새 글을 저장하고
		cafeService.insert(request);
		//view 페이지로 forward 이동
		return new ModelAndView("cafe/insert");
		
	}
	
	//새글 작성 폼 요청 처리
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInserform(HttpServletRequest request) {
		
		return new ModelAndView("cafe/insertform");
	}
	
	//글 자세히 보기 요청 처리
	@RequestMapping("/cafe/detail")
	public ModelAndView detail(HttpServletRequest request) {
		//서비스 객체를 이용해서 글 자세히 보기에 관련된 Model이 request에 담기게 하고
		 cafeService.detail(request);
		//view 페이지로 forward 이동
		 return new ModelAndView("cafe/detail");
		
	}
	//삭제
	@RequestMapping("/cafe/delete")
	public ModelAndView authDelete(HttpServletRequest request, @RequestParam int num) {
		cafeService.delete(request, num);
		return new ModelAndView("cafe/delete");
	}
	
	//수정
	@RequestMapping("/cafe/update")
	public ModelAndView authUpdate(HttpServletRequest request) {
		cafeService.update(request);
		return new ModelAndView("cafe/update");
	}
	
	//수정 폼
	@RequestMapping("/cafe/updateform")
	public ModelAndView authUpdateForm(HttpServletRequest request) {
		cafeService.updateform(request);
		return new ModelAndView("cafe/updateform");
	}
	
	//새 댓글 저장
	@RequestMapping("/cafe/comment_insert")
	public ModelAndView commentInsert(
			HttpServletRequest request,
			@ModelAttribute CafeCommentDto dto) {
		ModelAndView mView=new ModelAndView();
		cafeService.commentInsert(dto, mView);
		mView.setViewName("redirect:/cafe/detail.do?num="+dto.getRef_group());
		return mView;
	}
}
