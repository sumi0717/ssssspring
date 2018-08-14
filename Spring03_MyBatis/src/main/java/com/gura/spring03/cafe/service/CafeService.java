package com.gura.spring03.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.cafe.dto.CafeCommentDto;
import com.gura.spring03.cafe.dto.CafeDto;

public interface CafeService {
	public void insert(HttpServletRequest request);
	public void getList(HttpServletRequest request);
	public void detail(HttpServletRequest request);
	public void delete(HttpServletRequest request, int num);
	public void update(HttpServletRequest request);
	public void updateform(HttpServletRequest request);
	public void commentInsert(CafeCommentDto dto, ModelAndView mView);
}
