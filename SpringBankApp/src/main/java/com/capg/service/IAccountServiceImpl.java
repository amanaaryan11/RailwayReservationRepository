package com.capg.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.beans.AccountDetails;
import com.capg.beans.User;
import com.capg.dao.IAccountRepository;
import com.capg.dao.IUserRepoitory;
import com.capg.exception.InsufficientBalanceException;
import com.capg.exception.InvalidPhoneNumberException;
import com.capg.exception.UserExistsException;

@Service
public class IAccountServiceImpl implements IAccountService {

	@Autowired
	IAccountRepository accRepo;

	@Autowired
	IUserRepoitory userRepo;

	@Override
	public Boolean addMoneyToWallet(Integer amount, Long phoneNumber, Long accountNumber)  {
		boolean flag = false;
		int walletBalance;
		
		if(Pattern.matches("[6-9]{1}[0-9]{9}", phoneNumber.toString())) {
		List<AccountDetails> list=accRepo.checkPhoneLinkedToAccount(phoneNumber,accountNumber); 
		if(list.isEmpty()) {
			throw new InvalidPhoneNumberException("Phone Number not linked to AccountNumber");
		}
		else {
		int availableBalance = accRepo.getBalance(accountNumber);
		if (availableBalance >= amount) {
			availableBalance = availableBalance - amount;
			accRepo.updateBalance(accountNumber, availableBalance);
			walletBalance = userRepo.getWalletBalance(phoneNumber);
			walletBalance += amount;
			userRepo.updateWalletBalance(phoneNumber, walletBalance);
			flag = true;
		}
		else if(!flag){
			throw new InsufficientBalanceException("Insufficient Account balance");
		}
		
	}}else {
		throw new InvalidPhoneNumberException("Phone Number must be of 10 digits");
	}
		return flag;
		
		
	}

	@Override
	public Boolean completePayment(Integer amount, Long phoneNumber) {
		boolean flag = false;
		int walletBalance = userRepo.getWalletBalance(phoneNumber);
		if (walletBalance >= amount) {
			walletBalance -= amount;
			userRepo.updateWalletBalance(phoneNumber, walletBalance);
			flag = true;
		}

		else if(!flag){
			throw new InsufficientBalanceException("Insufficient wallet balance to make payment");
		}
		return flag;
	}
	
	@Override
	public AccountDetails addNewAccountDetails(AccountDetails accountobj) {
		
		List<User> Flag = userRepo.checkUserExists(accountobj.getPhoneNumber());
		if (!Flag.isEmpty()) {
		
		
		List<AccountDetails> phoneNumberFlag = accRepo.checkPhoneExists(accountobj.getPhoneNumber());
		if (phoneNumberFlag.isEmpty()) {

			List<AccountDetails> accountNumberFlag = accRepo.checkAccountExists(accountobj.getAccountNumber());
			if (accountNumberFlag.isEmpty()) {

				accRepo.save(accountobj);
			} else {
				throw new UserExistsException("Account Number already exists");
			}
		} else {
			throw new UserExistsException("Phone Number already exists");
		}
		}else {
			throw new UserExistsException("Phone Number not registered");
		}
		return accountobj;


}}
