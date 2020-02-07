package com.capg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.capg.beans.User;

public interface IUserRepoitory extends JpaRepository<User, Long> {
	
	 @Transactional
	 @Modifying 
	 @Query(value = "UPDATE User_Details SET WALLET_BALANCE  =?2 WHERE  PHONE_NUMBER =?1 ", nativeQuery = true)
	 void updateWalletBalance(Long phoneNumber, Integer amount);
     
	 @Query(value="SELECT  WALLET_BALANCE FROM User_Details  WHERE PHONE_NUMBER =?1 ", nativeQuery = true)
     Integer getWalletBalance(Long phoneNumber);

	 @Query("from User where phoneNumber=?1")
	List<User> checkUserExists(Long phoneNumber);
    
	 
	
     
	

}
