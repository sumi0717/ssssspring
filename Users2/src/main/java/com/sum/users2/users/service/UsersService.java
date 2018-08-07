package com.sum.users2.users.service;

import org.springframework.web.servlet.ModelAndView;

import com.sum.users2.users.dto.UsersDto;



public interface UsersService {
	public void list(ModelAndView mView);
	public void insert(UsersDto dto);
	public void update(UsersDto  dto);
	public void delete(int num);
	public void getData(ModelAndView mView, int num);
	public void login(ModelAndView mView, UsersDto dto);
}
