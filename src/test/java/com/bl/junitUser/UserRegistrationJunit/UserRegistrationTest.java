package com.bl.junitUser.UserRegistrationJunit;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class UserRegistrationTest 
{
	UserValidation userRegister = null;
	
	@Before
	public void initialize() {
		userRegister = new UserValidation();
	}
	
    @Test
    public void shouldPrintWelcomeMsg()
    {
        boolean welcome = userRegister.printWelcome();
        Assert.assertEquals(true, welcome);
    }
    
//    test cases for validating first name
    @Test
    public void firstName_whenValid_returnValid() {
    	boolean firstName;
		try {
			firstName = userRegister.validateName("Jagriti");
			 Assert.assertEquals(true, firstName);
		} catch (UserValidationExceptions e) {
			System.out.println(e.exceptionType);
		}
    }
    
    @Test
    public void firstName_whenInValid_returnInValid() {
    	boolean firstName;
		try {
			firstName = userRegister.validateName("qwer");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.NAME_INVALID, e.exceptionType);
		}
    } 
    
//  test cases for validating last name
    @Test
    public void lastName_whenValid_returnValid() {
    	boolean lastName;
		try {
			lastName = userRegister.validateName("Agni");
			 Assert.assertEquals(true, lastName);
		} catch (UserValidationExceptions e) {
			System.out.println(e.exceptionType);
		}
    } 
    
    @Test
    public void lastName_whenInValid_returnInValid() {
    	boolean lastName;
		try {
			lastName = userRegister.validateName("qwerty");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.NAME_INVALID, e.exceptionType);
		}
    } 
    
// test cases for validating emails
    @Test
    public void email_whenValid_returnValid() {
    	boolean email;
		try {
			email = userRegister.validateEmail("abc.xyz@bl.co.in");
	        Assert.assertEquals(true, email);
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
		}
    } 
    
    @Test
    public void email_whenInValid_returnInValid() {
    	boolean email;
		try {
			email = userRegister.validateEmail("abcbl.co.in");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.EMAIL_INVALID, e.exceptionType);
		}
    } 
 
// test cases for validating phone numbers
    @Test
    public void phoneNo_whenValid_returnValid() {
    	boolean phoneCheck;
		try {
			phoneCheck = userRegister.validateMobile("91 1234521361");
			Assert.assertEquals(true, phoneCheck);
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
		}
    }
    
    @Test
    public void phoneNo_whenNoSpace_returnInValid() {
    	boolean phoneCheck;
		try {
			phoneCheck = userRegister.validateMobile("911234521361");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PHONE_NUM_INVALID, e.exceptionType);
		}
    	
    }
    @Test
    public void phoneNo_whenDigitsNotCorrect_returnInValid() {
    	boolean phoneCheck;
		try {
			phoneCheck = userRegister.validateMobile("9234521361");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PHONE_NUM_INVALID, e.exceptionType);
		}
    }
    
 // test cases to check if password is valid (more than 8 char and atleast one upper case)
    @Test
    public void password_whenLengthEightAUpperCaseANumber_returnValid() {
    	boolean passCheck;
		try {
			passCheck = userRegister.validatePassword("Hello@123Hi");
	    	Assert.assertEquals(true, passCheck);
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
		}
    }
    
    @Test
    public void password_whenNoUpperCase_returnInValid() {
    	boolean passCheck;
		try {
			passCheck = userRegister.validatePassword("789*uigh");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PASSWORD_INVALID, e.exceptionType);
		}
    }
    @Test
    public void password_whenLengthMoreThanEightNoUpperCase_returnInValid() {
    	boolean passCheck;
		try {
			passCheck = userRegister.validatePassword("abc#$79*uigh");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PASSWORD_INVALID, e.exceptionType);
		}
    }
    @Test
    public void password_whenLengthLessThanEight_returnInValid() {
    	boolean passCheck;
		try {
			passCheck = userRegister.validatePassword("abc#$");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PASSWORD_INVALID, e.exceptionType);
		}
    }
    @Test
    public void password_whenNoNumber_returnInValid() {
    	boolean passCheck;
		try {
			passCheck = userRegister.validatePassword("Hello@hii");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PASSWORD_INVALID, e.exceptionType);
		}
    }
    @Test
    public void password_whenNoSpecialChar_returnInValid() {
    	boolean passCheck;
		try {
			passCheck = userRegister.validatePassword("Hello123hii");
		} catch (UserValidationExceptions e) {
			System.out.println(e.getMessage() + " " + e.exceptionType);
			Assert.assertEquals(UserValidationExceptions.ExceptionType.PASSWORD_INVALID, e.exceptionType);
		}
    }
}
