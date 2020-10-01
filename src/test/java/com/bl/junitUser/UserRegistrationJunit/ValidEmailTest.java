package com.bl.junitUser.UserRegistrationJunit;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ValidEmailTest {
	
	private String email;
	private boolean isEmailValid;
	private UserValidation userRegister = null;
	
	public ValidEmailTest(String email, boolean isEmailValid) {
		super();
		this.email = email;
		this.isEmailValid = isEmailValid;
	}
	@Before
	public void initialize() {
		userRegister = new UserValidation();
	}
	
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] { 
			 {"abc", false}, {"abc@yahoo.com", true}, {"abc-100@yahoo.com", true}, 
			 {"abc111@abc.com", true}, {"abc.100@yahoo.com", true}, {"abc-100@abc.net", true},
			 {"abc.100@abc.com.au", true}, {"abc@1.com", true}, {"abc@gmail.com.com", false}, 
			 {"abc+100@gmail.com", true}, {"abc123@gmail.a", false}, {"abc123@.com", false }, 
			 {"abc123@.com.com", false}, {".abc@abc.com", false}, {"abc()*@gmail.com", false },
			 {"abc@%*.com", false},{"abc..2002@gmail.com", false},{"abc.@gmail.com", false },
			 {"abc@abc@gmail.com", false}, { "abc@gmail.com.1a", false}, 
			 {"abc@gmail.com.aa.au", false}, {"abc@.com.my", false} }
		);
	}
	
	@Test
	public void email_shouldReturnValidInvalid() {
		System.out.println("Is the email valid: " + isEmailValid);
		Assert.assertEquals(isEmailValid, userRegister.validateEmail(email));
	}
	
}
