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
    	boolean firstName = userRegister.validateName("Jagriti");
        Assert.assertEquals(true, firstName);
    }
    @Test
    public void firstName_whenInValid_returnInValid() {
    	boolean firstName = userRegister.validateName("qwer");
        Assert.assertEquals(false, firstName);
    } 
    
//  test cases for validating last name
    @Test
    public void lastName_whenValid_returnValid() {
    	boolean lastName = userRegister.validateName("Agni");
        Assert.assertEquals(true, lastName);
    } 
    @Test
    public void lastName_whenInValid_returnInValid() {
    	boolean lastName = userRegister.validateName("one");
        Assert.assertEquals(false, lastName);
    } 
    
// test cases for validating emails
    @Test
    public void email_whenValid_returnValid() {
    	boolean email = userRegister.validateEmail("abc.xyz@bl.co.in");
        Assert.assertEquals(true, email);
    } 
    @Test
    public void email_whenInValid_returnInValid() {
    	boolean email = userRegister.validateEmail("abcbl.co.in");
        Assert.assertEquals(false, email);
    } 
 
// test cases for validating phone numbers
    @Test
    public void phoneNo_whenValid_returnValid() {
    	boolean phoneCheck = userRegister.validateMobile("91 1234521361");
    	Assert.assertEquals(true, phoneCheck);
    }
    @Test
    public void phoneNo_whenNoSpace_returnValid() {
    	boolean phoneCheck = userRegister.validateMobile("911234521361");
    	Assert.assertEquals(false, phoneCheck);
    }
    @Test
    public void phoneNo_whenDigitsNotCorrect_returnValid() {
    	boolean phoneCheck = userRegister.validateMobile("9234521361");
    	Assert.assertEquals(false, phoneCheck);
    }
    
 // test cases to check if password is valid (more than 8 char and atleast one upper case)
    @Test
    public void password_whenLengthEightAUpperCaseANumber_returnValid() {
    	boolean passCheck = userRegister.validatePhoneRule1("78B9*uigh");
    	Assert.assertEquals(true, passCheck);
    }
    @Test
    public void password_whenNoUpperCase_returnInValid() {
    	boolean passCheck = userRegister.validatePhoneRule1("789*uigh");
    	Assert.assertEquals(false, passCheck);
    }
    @Test
    public void password_whenLengthMoreThanEightNoUpperCase_returnInValid() {
    	boolean passCheck = userRegister.validatePhoneRule1("abc#$79*uigh");
    	Assert.assertEquals(false, passCheck);
    }
    @Test
    public void password_whenLengthLessThanEight_returnInValid() {
    	boolean passCheck = userRegister.validatePhoneRule1("abc#$");
    	Assert.assertEquals(false, passCheck);
    }
    @Test
    public void password_whenNoNumber_returnInValid() {
    	boolean passCheck = userRegister.validatePhoneRule1("Hello@hii");
    	Assert.assertEquals(false, passCheck);
    }
    
}
