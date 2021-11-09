package com.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserAccountDetailsRepository extends JpaRepository<UserAccountdetails, Integer> {

	@Query(nativeQuery = true ,value="select * from user_account_details where user_name=? and password=?")
	public UserAccountdetails getUserAccountDeatils(@Param("username") String userName,@Param("password") String password );
	

}
