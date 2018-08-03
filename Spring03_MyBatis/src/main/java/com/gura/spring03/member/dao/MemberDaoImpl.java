package com.gura.spring03.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring03.member.dto.MemberDto;

//1. MemberDaoImpl 객체가 spring bean 컨테이너에서 관리되게 한다
@Repository
public class MemberDaoImpl implements MemberDao{
	@Autowired 
	private SqlSession session; //의존 객체 (이게 있어야 작업 가능)	
	//@Autowired는 의존객체 자동 주입 (Dependency Injection)
	//(스프링 컨테이너에 이런 타입 객체가 존재하면 자동으로 주입되게)
	//servlet-context.xml에 SqlSession 객체 설정해둔거 불러온 것임
	//이 어노테이션 붙여주면 setter 메소드를 자동으로 만들어서 데이터 넣어줌
	//따라서 null이 아니게 되므로 다른 메소드 구현 안하고 그냥 사용하면 됨
	//try, catch, session.close()할 필요 없음. 자동으로 관리해주므로
	
	
	@Override
	public void insert(MemberDto dto) {
		
		
	}

	@Override
	public void update(MemberDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberDto getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDto> getList() {
		
		List<MemberDto> list=session.selectList("member.getList");
		
		return list;
	}

}
