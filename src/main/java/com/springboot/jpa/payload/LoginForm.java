package com.springboot.jpa.payload;

import javax.validation.constraints.Size;

public class LoginForm {
	@Size(min=3,max=60)
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
