package com.gura.spring03.users.dto;

public class UsersDto {
	private String id;
	private String pwd;
	private String email;
	private String regdate;
	//디폴트 생성자, 호출할 때 이 생성자를 호출하는 것. 그러므로 생성자 없으면 안댐
	//이 상자에 포장해서 setter메소드 넣는다고 보면됨
	public UsersDto() {}
	
	public UsersDto(String id, String pwd, String email, String regdate) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
		this.regdate = regdate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
