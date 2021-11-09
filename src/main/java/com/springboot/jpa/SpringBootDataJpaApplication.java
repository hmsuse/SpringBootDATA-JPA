package com.springboot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaApplication implements CommandLineRunner{

	
	@Autowired
	UserAccountDetailsRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	List<UserAccountdetails> listUser=repo.findAll();
	if(!listUser.isEmpty()) {
		for(UserAccountdetails ub:listUser)
		System.out.println("ub--"+ub);
	}
	}

}
