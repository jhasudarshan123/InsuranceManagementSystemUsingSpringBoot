package com.javatpoint.DTO;

public class UserDTO {
	
	private int userid;
	private String username;
	private String password;
	private String email;
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(int userid, String username, String email, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
