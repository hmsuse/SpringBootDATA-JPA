package com.springboot.jpa.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.entity.UserAccountDetails;



public interface UserAccountDetailsRepository extends JpaRepository<UserAccountDetails, Integer> {

	@Query(nativeQuery = true ,value="select * from user_account_details where user_name=? and password=?")
	public UserAccountDetails getUserAccountDeatils(@Param("username") String userName,@Param("password") String password );
	
	@Query(nativeQuery = true ,value="select * from user_account_details where user_name=?")
	public UserAccountDetails findByName(@Param("username") String userName);

	@Query(nativeQuery = true ,value="select * from user_account_details where user_id=?")
	public UserAccountDetails findByUserId(@Param("userid") int parseInt);
	

}
