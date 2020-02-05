package com.capg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.beans.User;

@Repository
public interface IRegisterRepository extends JpaRepository<User, Long> {

	@Query("from User where phoneNumber=?1")
	List<User> checkUserExists(Long phoneNumber);

	@Query("from User where phoneNumber=?1")
	User getUserDetails(Long phoneNumber);

	@Query("Select walletBalance from User where phoneNumber=?1")
	Integer findWalletbalance(Long phoneNumber);

	

	

}
