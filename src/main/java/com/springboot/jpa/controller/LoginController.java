package com.springboot.jpa.controller;



import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.entity.UserAccountDetails;
import com.springboot.jpa.payload.JwtResponse;
import com.springboot.jpa.payload.LoginForm;
import com.springboot.jpa.reposiroty.UserAccountDetailsRepository;
import com.springboot.jpa.security.JwtProvider;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1")
public class LoginController {

	@Autowired
	UserAccountDetailsRepository userRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	@Autowired
	JwtProvider jwtProvider;
	
	@RequestMapping("/getUsersData")
	@ResponseBody
	public List<UserAccountDetails> getUsers(){
		
		//HashMap<String,Object> hm=new HashMap<>();
		return userRepo.findAll();
		//if(!data.isEmpty()) {
			//System.out.println("ub++"+data);
		//}
		//return hm;
		//System.exit(0);
		
	}
	@RequestMapping("/login")
	//@ResponseBody
	public ResponseEntity<?> loginRe(
		@Valid @RequestBody LoginForm loginRequest
			/*
											 * @RequestParam("userName") String username,
											 * 
											 * @RequestParam("password") String passWord
											 */){
		String jwt;
		HashMap<String,Object> hm=new HashMap<>();
		try {
			Authentication authentication = authenticationManager.authenticate(

					new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
					//new UsernamePasswordAuthenticationToken(username, passWord));

					System.out.println("user details==="+loginRequest.getUserName()+" asss"+ loginRequest.getPassword());
					System.out.println("authentication"+authentication);

					UserAccountDetails ubean = userRepo
					.getUserAccountDeatils(loginRequest.getUserName(), loginRequest.getPassword());
			if(ubean.getStatusId()!=5) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			jwt=jwtProvider.generateWebToken(authentication);
			return  ResponseEntity.ok(new JwtResponse(jwt, loginRequest.getUserName(),
					loginRequest.getPassword(), ubean.getUserType()));
				//hm.put("status", "success");
				//hm.put("msg", "user logined successfully");
				//hm.put("data", ubean);

			}else {
//				hm.put("status", "error");
//				hm.put("msg", "user is removed ");
//				hm.put("data", ubean);
				return  new ResponseEntity<String>("user is removed", new HttpHeaders(),HttpStatus.UNAUTHORIZED);
			}
			
		}catch(Exception e) {
//			hm.put("status", "error");
//			hm.put("msg", "user is not available please contact admin");
//			
			return  new ResponseEntity<String>("user is not available please contact admin", new HttpHeaders(),HttpStatus.UNAUTHORIZED);

		}
		
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String getString() {
		return "welcome to first app";
	}
	
}
