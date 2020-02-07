package com.capg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.capg.beans.AccountDetails;

public interface IAccountRepository  extends JpaRepository<AccountDetails,Long>{

	@Query("select balance from AccountDetails where accountNumber=?1")
	Integer getBalance(Long accountNumber);
    
	 @Transactional
	 @Modifying 
	@Query(value="UPDATE Account_Details SET BALANCE =?2 WHERE ACCOUNT_NUMBER =?1",nativeQuery = true)
	void updateBalance(Long accountNumber, Integer amount);
	 
	
	 @Query("From AccountDetails where phoneNumber=?1 AND accountNumber=?2")
	List<AccountDetails> checkPhoneLinkedToAccount(Long phoneNumber, Long accountNumber);

		@Query("from AccountDetails where phoneNumber=?1")
		List<AccountDetails> checkPhoneExists(Long phoneNumber);

		@Query("from AccountDetails where accountNumber=?1")
		List<AccountDetails> checkAccountExists(Long accountNumber);
	}


