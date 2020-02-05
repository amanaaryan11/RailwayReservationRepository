package com.capg.service;

public interface IAccountService {

	Boolean addMoneyToWallet(Integer amount, Long phoneNumber, Long accountNumber);

	Boolean completePayment(Integer amount, Long phoneNumber);

}
