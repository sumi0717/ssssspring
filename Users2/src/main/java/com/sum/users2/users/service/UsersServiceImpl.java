package com.sum.users2.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sum.users2.users.dao.UsersDao;
import com.sum.users2.users.dto.UsersDto;


@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UsersDao dao;
	
	@Override
	public void list(ModelAndView mView) {
		//Dao 객체를 이용해서 회원 목록을 얻어오고
		List<UsersDto > list=dao.getList();
		//인자로 전달된 ModelAndView 객체에 담는다
		mView.addObject("list", list);
		
		
	}

	@Override
	public void insert(UsersDto dto) {
		//MemberDao 객체를 이용해서 회원 정보를 DB에 저장하기
		dao.insert(dto);
		
	}

	@Override
	public void update(UsersDto dto) {

		dao.update(dto);
		
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
		
	}

	@Override
	public void getData(ModelAndView mView, int num) {
		UsersDto dto=dao.getData(num);
		mView.addObject("dto",dto);
		
	}

	@Override
	public void login(ModelAndView mView, UsersDto dto) {
		
		
	}
}
