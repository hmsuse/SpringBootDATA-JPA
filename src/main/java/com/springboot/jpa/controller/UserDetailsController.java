package com.springboot.jpa.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.entity.UserAccountDetails;
import com.springboot.jpa.entity.UserDetails;
import com.springboot.jpa.reposiroty.UserAccountDetailsRepository;


@RestController
@CrossOrigin(origins="*")
public class UserDetailsController {
	@Autowired
	UserAccountDetailsRepository userRepo;
	
	@RequestMapping("/addUpdateOfUser")
	@ResponseBody
	public HashMap<String,Object> addUser(@RequestBody UserDetails used,HttpServletRequest request,HttpServletResponse response){
		HashMap<String,Object> hm=new HashMap<>();
		String action=request.getParameter("action");
		if(action.equalsIgnoreCase("create")) {
		UserAccountDetails ub=userRepo.findByName(used.getUserName());
		if(!ub.getUserName().isEmpty()) {
			UserAccountDetails ubean=new UserAccountDetails();
			ubean.setEmail(used.getEmail());
			ubean.setFirstName(used.getFirstName());
			ubean.setLastName(used.getLastName());
			ubean.setUserName(used.getUserName());
			ubean.setUserType(used.getUserType());
			ubean.setStatusId(1);
			userRepo.save(ubean);

		}else {
			hm.put("status", "error");
			hm.put("msg", "given user name is already exists");

		}
		}else {
			
		}
		return hm;
		
		
		
	}
}
