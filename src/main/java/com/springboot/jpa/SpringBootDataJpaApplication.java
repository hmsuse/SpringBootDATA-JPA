package com.springboot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.jpa.entity.UserAccountDetails;

import com.springboot.jpa.reposiroty.UserAccountDetailsRepository;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{

	
	@Autowired
	UserAccountDetailsRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	List<UserAccountDetails> listUser=repo.findAll();
	if(!listUser.isEmpty()) {
		for(UserAccountDetails ub:listUser)
		System.out.println("ub--"+ub);
	}
	}

}
