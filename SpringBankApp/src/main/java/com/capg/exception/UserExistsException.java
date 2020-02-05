package com.capg.exception;

public class UserExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserExistsException(String message) {
		super(message);

	}

}
