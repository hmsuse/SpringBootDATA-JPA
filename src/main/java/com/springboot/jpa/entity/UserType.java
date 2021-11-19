package com.springboot.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_type")
public class UserType {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="usertype_id")
		private int usertypeId;
	
	@Column(name="name")
	private String name;

	public int getUsertype_id() {
		return usertypeId;
	}

	public void setUsertype_id(int usertype_id) {
		this.usertypeId = usertype_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
