package com.springboot.jpa.payload;

public class JwtResponse {

	private String token;
	private String type = "Bearer";
	private String userName;
	private String updatePassword;
	private int userType;

	public JwtResponse(String token, String userName, String updatepassword, int userType) {
		this.token = token;
		this.userName = userName;
		this.updatePassword = updatepassword;
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", type=" + type + ", userName=" + userName + ", updatePassword="
				+ updatePassword + ", userType=" + userType + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUpdatePassword() {
		return updatePassword;
	}

	public void setUpdatePassword(String updatePassword) {
		this.updatePassword = updatePassword;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
