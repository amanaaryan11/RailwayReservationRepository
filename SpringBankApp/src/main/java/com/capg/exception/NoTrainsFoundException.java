package com.capg.exception;

public class NoTrainsFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoTrainsFoundException(String message) {
		super(message);
	}
}
