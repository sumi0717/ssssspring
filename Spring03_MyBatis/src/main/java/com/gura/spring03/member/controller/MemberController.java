package com.gura.spring03.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;

@Controller //원랜 service를 통해서 코딩해야되는데 임시로 Dao 이용
public class MemberController {
	//임시 코딩
	@Autowired
	private MemberDao dao;
	
	
	@RequestMapping("/member/list")
	public ModelAndView list() {
		
		List<MemberDto> list=dao.getList();
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("list",list);
		// /WEB-INF/views/member/list.jsp랑 같음. prefix, suffix 자동으로 붙는것
		mView.setViewName("member/list");
		
		return mView;
	}
}
