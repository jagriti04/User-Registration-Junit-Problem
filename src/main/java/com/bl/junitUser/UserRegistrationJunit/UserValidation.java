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
		
		public static boolean regexMatch(String matchContent, String patternString) {  	
			Pattern pattern = Pattern.compile(patternString);
		    Matcher matcher = pattern.matcher(matchContent);
		    boolean isMatch = matcher.find();		    
			System.out.println(matchContent+" is " + isMatch);
			return isMatch;
		}
}
