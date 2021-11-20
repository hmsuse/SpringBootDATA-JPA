package com.springboot.jpa.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.entity.UserAccountDetails;
import com.springboot.jpa.entity.UserDetails;
import com.springboot.jpa.reposiroty.UserAccountDetailsRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")

public class UserDetailsController {
	@Autowired
	UserAccountDetailsRepository userRepo;

	@RequestMapping("/addUpdateOfUser")
	@ResponseBody
	public HashMap<String, Object> addUser(@RequestBody UserDetails used, HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Object> hm = new HashMap<>();
		String action = request.getParameter("action");
		try {
			if (action.equalsIgnoreCase("create")) {
				UserAccountDetails ub = userRepo.findByName(used.getUserName());
				if (ub==null) {
					UserAccountDetails ubean = new UserAccountDetails();
					ubean.setEmail(used.getEmail());
					ubean.setFirstName(used.getFirstName());
					ubean.setLastName(used.getLastName());
					ubean.setUserName(used.getUserName());
					ubean.setUserType(used.getUserType());
					ubean.setPassword(used.getPhoneNo());
					ubean.setStatusId(1);
					ubean.setPhoneNumber(used.getPhoneNo());

					userRepo.save(ubean);
					hm.put("status", "success");
					hm.put("msg", "User  is created successfully");

				} else {
					hm.put("status", "error");
					hm.put("msg", "given user name is already exists");

				}
			} else {
				UserAccountDetails ubean = userRepo.findByName(used.getUserName());
				if (!ubean.getUserName().isEmpty()) {
					
					ubean.setEmail(used.getEmail());
					ubean.setFirstName(used.getFirstName());
					ubean.setLastName(used.getLastName());
					ubean.setUserName(used.getUserName());
					ubean.setUserType(used.getUserType());
					ubean.setPassword(used.getPhoneNo());
					ubean.setPhoneNumber(used.getPhoneNo());
					ubean.setStatusId(1);
					hm.put("status", "success");
					hm.put("msg", "User  is updated successfully");

				} else {
					hm.put("status", "error");
					hm.put("msg", "given user details does not exists to update");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;

	}

	@RequestMapping("/editUser")
	@ResponseBody
	public HashMap<String, Object> editUser(@RequestParam("userId") String userId, HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Object> hm = new HashMap<>();

		try {

			UserAccountDetails ub = userRepo.findByUserId(Integer.parseInt(userId));
			if (ub.getUser_id() > 0) {
				hm.put("userName", ub.getUserName());
				hm.put("firstName", ub.getFirstName());
				hm.put("lastName", ub.getLastName());
				hm.put("email", ub.getEmail());
				boolean deleted = ub.getStatusId() == 5 ? true : false;
				hm.put("deleted", deleted);
				String userType = ub.getUserType() == 1 ? "admin" : "accountant";
				hm.put("userType", userType);
				hm.put("phoneNumber", ub.getPhoneNumber());
				hm.put("status", "success");
				hm.put("msg", "User  data retrieved successfully");

			} else {
				hm.put("status", "error");
				hm.put("msg", "Given user details does not exists");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	public HashMap<String, Object> deleteUser(@RequestParam("userId") String userId, HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Object> hm = new HashMap<>();

		try {

			UserAccountDetails ub = userRepo.findByUserId(Integer.parseInt(userId));
			if (ub.getUser_id() > 0) {
				if (ub.getStatusId() == 1) {

					ub.setStatusId(5);
					userRepo.save(ub);
					hm.put("status", "success");
					hm.put("msg", "User deleted successfully");

				} else {
					hm.put("status", "error");
					hm.put("msg", "Given user is not in active state to delete");

				}
			} else {
				hm.put("status", "error");
				hm.put("msg", "Given user details not exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hm;
	}
}
