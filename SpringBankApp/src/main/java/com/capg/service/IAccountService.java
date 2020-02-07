package com.capg.service;

import com.capg.beans.AccountDetails;

public interface IAccountService {

	Boolean addMoneyToWallet(Integer amount, Long phoneNumber, Long accountNumber);

	Boolean completePayment(Integer amount, Long phoneNumber);
	
	AccountDetails addNewAccountDetails(AccountDetails accountobj);


}
