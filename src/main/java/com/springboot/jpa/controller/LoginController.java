package com.springboot.jpa.controller;



import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.jpa.UserAccountDetailsRepository;
import com.springboot.jpa.UserAccountdetails;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	UserAccountDetailsRepository userRepo;
	
	@RequestMapping("/getUsersData")
	@ResponseBody
	public List<UserAccountdetails> getUsers(){
		
		//HashMap<String,Object> hm=new HashMap<>();
		return userRepo.findAll();
		//if(!data.isEmpty()) {
			//System.out.println("ub++"+data);
		//}
		//return hm;
		//System.exit(0);
		
	}
	@RequestMapping("/login")
	@ResponseBody
	public HashMap<String,Object> login(@RequestParam("userName") String username,
			@RequestParam("password") String passWord){
		HashMap<String,Object> hm=new HashMap<>();
		try {
			
			UserAccountdetails ubean = userRepo
					.getUserAccountDeatils(username,passWord);
			if(ubean.getStatusId()!=5) {
			//jwt=jwtProvider.generateWebToken(authentication);
			//return new ResponseEntity<String>("success", HttpStatus.OK);
				hm.put("status", "success");
				hm.put("msg", "user logined successfully");
				hm.put("data", ubean);

			}else {
				hm.put("status", "error");
				hm.put("msg", "user is removed ");
				hm.put("data", ubean);
			}
			
		}catch(Exception e) {
			hm.put("status", "error");
			hm.put("msg", "user is not available please contact admin");
			
		}
		return hm;
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String getString() {
		return "welcome to first app";
	}
	
}
