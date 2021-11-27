package com.springboot.jpa.security.jwt.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.UserAccountDetails;
import com.springboot.jpa.reposiroty.UserAccountDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserAccountDetailsRepository userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserAccountDetails user;
		try {
			user=userRepo.findByName(username);
			return UserPrinciple.build(user);
		}catch(Exception e) {
			return (UserDetails) new UsernameNotFoundException("user not found");
		}
		
	}

}
