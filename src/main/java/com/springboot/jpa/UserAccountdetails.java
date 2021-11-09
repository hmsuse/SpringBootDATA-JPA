package com.springboot.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_account_details")
public class UserAccountdetails {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
@Column(name="user_id")
	private int user_id;

@Column(name="user_name")
private String userName;

@Column(name="password")
private String password;

@Column(name="first_name")
private String firstName;

@Column(name="last_name")
private String lastName;

@Column(name="middle_name")
private String middleName;

@Column(name="email")
private String email;

@Column(name="status_id")
private int statusId;



public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

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

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}



public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}


public int getStatusId() {
	return statusId;
}

public void setStatusId(int statusId) {
	this.statusId = statusId;
}



public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

}	
	