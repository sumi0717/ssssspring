package com.sum.users2.users.dao;

import java.util.List;

import com.sum.users2.users.dto.UsersDto;



public interface UsersDao {
	public void insert(UsersDto dto);
	public void update(UsersDto dto);
	public void delete(int num);
	public UsersDto getData(int num);
	public List<UsersDto> getList();
	public boolean isValid(UsersDto dto);
}
