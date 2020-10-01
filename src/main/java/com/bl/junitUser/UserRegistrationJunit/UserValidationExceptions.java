package com.bl.junitUser.UserRegistrationJunit;

public class UserValidationExceptions extends Exception {
	enum ExceptionType {
		ENTERED_NULL, ENTERED_EMPTY, NAME_INVALID, 
		EMAIL_INVALID, PHONE_NUM_INVALID, PASSWORD_INVALID
	}
	ExceptionType exceptionType;
	
	public UserValidationExceptions(ExceptionType exceptionType,  String message) {
		super(message);
		this.exceptionType = exceptionType;
	}
	
}
