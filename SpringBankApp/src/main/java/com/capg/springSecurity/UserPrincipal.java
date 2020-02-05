package com.capg.springSecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.capg.beans.User;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class UserPrincipal implements UserDetails{
	
	private Long phoneNumber;
	private String firstname;
	private String lastName;
	private String emailId;
	private String authority;
	private Integer age;
	private String password;
	private Integer walletBalance;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserPrincipal(Long phoneNumber, String firstname, String lastName, String emailId, String authority,
			Integer age, String password, Integer walletBalance, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.phoneNumber = phoneNumber;
		this.firstname = firstname;
		this.lastName = lastName;
		this.emailId = emailId;
		this.authority = authority;
		this.age = age;
		this.password = password;
		this.walletBalance = walletBalance;
		this.authorities = authorities;
	}

	
	
	 public static UserPrincipal create(User user) {
	        List<GrantedAuthority> authorities = new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority("User"));
	        authorities.add(new SimpleGrantedAuthority("Admin"));

	        return new UserPrincipal(
	                user.getPhoneNumber(),
	                user.getFirstname(),
	                user.getLastName(),
	                user.getEmailId(),
	                user.getAuthority(),
	                user.getAge(),
	                user.getPassword(),
	                user.getWalletBalance(),
	                authorities
	        );
	    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return phoneNumber.toString();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
