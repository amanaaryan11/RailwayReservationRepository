package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.beans.AccountDetails;
import com.capg.dao.IAccountRepository;
import com.capg.dao.IUserRepoitory;
import com.capg.exception.InsufficientBalanceException;
import com.capg.exception.InvalidPhoneNumberException;

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

}
