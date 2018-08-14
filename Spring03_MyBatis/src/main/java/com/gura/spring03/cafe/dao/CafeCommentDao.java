package com.gura.spring03.cafe.dao;

import java.util.List;

import com.gura.spring03.cafe.dto.CafeCommentDto;

public interface CafeCommentDao {
	//뉴 댓글의 글 번호를 리턴하는 메소드
	public int getSequence();
	//새 댓글 저장하는 메소드
	public void insert(CafeCommentDto dto);
	//댓글 목록을 리턴하는 메소드
	public List<CafeCommentDto> getList(int ref_group);
	
}
