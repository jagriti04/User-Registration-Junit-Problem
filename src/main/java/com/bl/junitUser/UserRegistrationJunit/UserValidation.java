package com.bl.junitUser.UserRegistrationJunit;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

@FunctionalInterface
interface PatternValidationFunction {
	 public boolean regexMatch(String matchContent, String patternString);
}

public class UserValidation {
	
		public boolean printWelcome() {
			System.out.println("Welcome to the user validation system");
			return true;
		}
		
		// same function for first and last name validation
		public boolean validateName(String name) throws UserValidationExceptions {
			
			String patternString = "(^[A-Z])[A-Za-z]{2,}$";
			boolean matches = regexMatchFun.regexMatch(name, patternString);
			
			if (matches == false) {
				throw new UserValidationExceptions(UserValidationExceptions.ExceptionType.NAME_INVALID, "Enter proper name");
			} 
			return matches;
		}
		
		public boolean validateEmail(String email) throws UserValidationExceptions {
			String patternString = "^[a-zA-z]{1}([.]{0,1}[a-zA-z0-9+-]{1,}){0,}[@]{1}[a-zA-Z0-9]{1,}[.]{1}[a-z]{2,3}([.]{1}[a-z]{2}){0,1}$";
			boolean emailMatches = regexMatchFun.regexMatch(email, patternString);
			if (emailMatches == false) {
				throw new UserValidationExceptions(UserValidationExceptions.ExceptionType.EMAIL_INVALID, "Enter proper email");
			} 
			return emailMatches;
		}
		
		public boolean validateMobile(String mobileNum) throws UserValidationExceptions {
			String patternString = "^([0-9]{2})[\\s]([0-9]{10})";
			boolean phoneMatches = regexMatchFun.regexMatch(mobileNum, patternString);
			if (phoneMatches == false) {
				throw new UserValidationExceptions(UserValidationExceptions.ExceptionType.PHONE_NUM_INVALID, "Enter proper phone no.");
			} 
			return phoneMatches;
		}

		public boolean validatePassword(String password) throws UserValidationExceptions {
			String patternString = "^(?=.*\\d)(?=[^!@#$%^&*()_+=]*[!@#$%^&*()_+=][^!@#$%^&*()_+=]*$)(?=.*[A-Z]).{8,}$";
			boolean passMatches = regexMatchFun.regexMatch(password, patternString);
			if (passMatches == false) {
				throw new UserValidationExceptions(UserValidationExceptions.ExceptionType.PASSWORD_INVALID, "Enter proper password");
			} 
			return passMatches;
		}
		
		PatternValidationFunction regexMatchFun = (String matchContent, String patternString) -> {  	
			Pattern pattern = Pattern.compile(patternString);
		    Matcher matcher = pattern.matcher(matchContent);
		    boolean isMatch = matcher.find();		   
			return isMatch;
		};

}
