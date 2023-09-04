package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.exception.InvalidUserException;

 class TestValidateEmail {
 
    @Test
    void testValidEmail() {
        String validEmail = "lakshmipriya@example.com";
        try {
			assertTrue(UserValidator.validateEmail(validEmail));
		} catch (InvalidUserException e) {
			fail();
			e.printStackTrace();
		}
    }

    
    @Test
    void testInvalidEmailMissingAtSymbol() {
        String invalidEmail = "lakshmipriya.com";
        try {
			assertFalse(UserValidator.validateEmail(invalidEmail));
		} catch (InvalidUserException e) {
			
			e.printStackTrace();
		}
    }

    @Test
 void testInvalidEmailMissingDomain() {
        String invalidEmail = "lakshmipriya@";
        try {
			assertFalse(UserValidator.validateEmail(invalidEmail));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

  

    @Test
    void testInvalidEmailNullInput() {
        String invalidEmail = null;
        try {
			assertFalse(UserValidator.validateEmail(invalidEmail));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    void testInvalidEmailEmptyInput() {
        String invalidEmail = "";
        try {
			assertFalse(UserValidator.validateEmail(invalidEmail));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
