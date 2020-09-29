package com.bl.junitUser.UserRegistrationJunit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidation {
	
		public boolean printWelcome() {
			System.out.println("Welcome to the user validation system");
			return true;
		}
		// same function for first and last name validation
		public boolean validateName(String name) {
			String patternString = "(^[A-Z])[A-Za-z]{2,}$";
			boolean matches = regexMatch(name, patternString);
			return matches;
		}
		
		public boolean validateEmail(String email) {
			String patternString = "^[a-zA-z]{1}([.]{0,1}[a-zA-z0-9+-]{1,}){0,}[@]{1}[a-zA-Z0-9]{1,}[.]{1}[a-z]{2,3}([.]{1}[a-z]{2}){0,1}$";
			boolean emailMatches = regexMatch(email, patternString);
			return emailMatches;
		}
		
		public boolean validateMobile(String mobileNum) {
			String patternString = "^([0-9]{2})[\\s]([0-9]{10})";
			boolean phoneMatches = regexMatch(mobileNum, patternString);
			return phoneMatches;
		}
		
		public static boolean regexMatch(String matchContent, String patternString) {  	
			Pattern pattern = Pattern.compile(patternString);
		    Matcher matcher = pattern.matcher(matchContent);
		    boolean isMatch = matcher.find();		    
			System.out.println(matchContent+" is " + isMatch);
			return isMatch;
		}
}
