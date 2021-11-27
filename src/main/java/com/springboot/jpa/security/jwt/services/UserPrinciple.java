package com.springboot.jpa.security.jwt.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.jpa.entity.UserAccountDetails;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String userName;
	private String email;


	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return authorities;
		}

		public UserPrinciple(int id, String name, String userName,
				String email, String password,
				Collection<? extends GrantedAuthority> authorities) {
			
			this.id = id;
			this.name = name;
			this.userName = userName;
			this.email = email;
			this.password = password;
			this.authorities = authorities;
		}

		public static UserPrinciple build(UserAccountDetails uabean) {
			Collection authorities=new ArrayList<>();
			return new UserPrinciple(uabean.getUser_id(),
					uabean.getFirstName()
					, uabean.getUserName(), 
					uabean.getEmail(), uabean.getPassword(),
					 authorities)
					;
			
			
		}
		
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return password;
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return userName;
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}

		public int getId() {
			return id;
		}

		

		public String getName() {
			return name;
		}

		

		public String getEmail() {
			return email;
		}

		

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass())
				return false;
			UserPrinciple other = (UserPrinciple) obj;
			return Objects.equals(id, other.id);
		}

		
}
