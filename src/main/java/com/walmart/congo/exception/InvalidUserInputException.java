package com.walmart.congo.exception;

@SuppressWarnings("serial")
public class InvalidUserInputException extends RuntimeException {
	public InvalidUserInputException(String message) {
		super(message);
	}
}
