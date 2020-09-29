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
}
