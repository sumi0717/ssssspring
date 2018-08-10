package com.gura.spring03.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.gura.spring03.file.dto.FileDto;

@Repository
public class FileDaoImpl implements FileDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void delete(int num) {
		session.delete("file.delete", num);
	}

	@Override
	public void addDownCount(int num) {
		session.update("file.addDownCount", num);
	}

	@Override
	public FileDto getData(int num) {
		
		return session.selectOne("file.getData", num);
	}

	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert", dto);
	}

	@Override
	public List<FileDto> getList(FileDto dto) {
		
		throw new DataAccessException("파일 목록 안보이게 하기") {
			
		};
		
		//return session.selectList("file.getList", dto);
	}

	@Override
	public int getCount() {
		return session.selectOne("file.getCount");
	}

}