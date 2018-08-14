package com.gura.spring03.cafe.dao;

import java.util.List;

import com.gura.spring03.cafe.dto.CafeDto;

public interface CafeDao {
	public void insert(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글의 갯수를 리턴하는 메소드
	//키워드 검색의 경우, 인자로 전달되는 글 갯수를 전달해줌 => getCount
	public int getCount(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글 목록을 리턴하는 메소드
	//페이지에 맞는 글 목록 리턴
	public List<CafeDto> getList(CafeDto dto);
	//인자로 전달되는 정보에 맞는 글 하나의 정보를 리턴하는 메소드
	public CafeDto getData(CafeDto dto);
	
	public void delete(int num);
	public void update(CafeDto dto);
	public void addViewCount(int num);
}
