package com.capg.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name= "Account_Details")
public class AccountDetails {
	
	@Id
	private Long accountNumber;
	private Long phoneNumber;
	private Double balance;
	
	
	public AccountDetails() {
		super();
	}
	
	


	public AccountDetails(Long accountNumber, Long phoneNumber, Double balance) {
		super();
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
	}




	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "AccountDetails [phoneNumber=" + phoneNumber + ", accountNumber=" + accountNumber + ", balance="
				+ balance + "]";
	}
	
	
	
	

}
