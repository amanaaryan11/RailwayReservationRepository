package com.capg.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.capg.beans.User;
import com.capg.dao.IUserRepoitory;
import com.capg.exception.UserNotFoundException;




@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	@Autowired
	IUserRepoitory userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String phoneNumber)  {
		User user = userRepository.findById(Long.parseLong(phoneNumber)).orElseThrow(
	            () -> new UsernameNotFoundException("Phone Number not found")
	        );

	        return UserPrincipal.create(user);
	    }

	
	 public UserDetails loadUserById(Long phoneNumber)  {
	        User user = userRepository.findById(phoneNumber).orElseThrow(
	            () -> new UserNotFoundException("Phone Number not found")
	        );

	        return UserPrincipal.create(user);
	    }


	

}
