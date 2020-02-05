package com.capg.exceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.exception.InvalidPhoneNumberException;
import com.capg.exception.InvalidPnrException;
import com.capg.exception.InvalidTrainNoException;
import com.capg.exception.NoTrainsFoundException;
import com.capg.exception.SeatUnAvailabiltyException;
import com.capg.exception.UserExistsException;
import com.capg.exception.UserNotFoundException;
import com.capg.exception.InsufficientBalanceException;
@RestControllerAdvice
public class RailwayExceptionHandler {

	@ExceptionHandler(InvalidPnrException.class)
	public String InvalidPnrNo(InvalidPnrException e) {

		return e.getMessage();
	}

	@ExceptionHandler(SeatUnAvailabiltyException.class)
	public String SeatUnAvailabilty(SeatUnAvailabiltyException e) {

		return e.getMessage();
	}
	
	@ExceptionHandler(InvalidTrainNoException.class)
	public String InvalidTrainNo(InvalidTrainNoException e) {

		return e.getMessage();
	}

	@ExceptionHandler(UserNotFoundException.class)
	public String InvalidUserName(UserNotFoundException e) {

		return e.getMessage();
	}
	@ExceptionHandler(NoTrainsFoundException.class)
	public String NoTrainsFound(NoTrainsFoundException e) {

		return e.getMessage();
	}

	@ExceptionHandler(InvalidPhoneNumberException.class)
	public String InvalidPhoneNumber(InvalidPhoneNumberException e) {

		return e.getMessage();
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public String InsufficientBalanceException(InsufficientBalanceException e) {

		return e.getMessage();
	}
	
	@ExceptionHandler(UserExistsException.class)
	public String UserExists(UserExistsException e) {

		return e.getMessage();
	}
	
}
