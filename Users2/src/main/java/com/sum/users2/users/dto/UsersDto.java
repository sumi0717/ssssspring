package com.sum.users2.users.dto;

public class UsersDto {
	private int num;
	private String id;
	private String pwd;
	private String regdate;
	
	public UsersDto() {};
	
	public UsersDto(int num, String id, String pwd, String regdate) {
		super();
		this.num = num;
		this.id = id;
		this.pwd = pwd;
		this.regdate = regdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
