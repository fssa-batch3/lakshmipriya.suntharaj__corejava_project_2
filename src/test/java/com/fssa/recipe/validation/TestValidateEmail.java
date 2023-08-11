package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.UserValidator;

public class TestValidateEmail {
 
    @Test
    public void testValidEmail() {
        String validEmail = "lakshmipriya@example.com";
        assertTrue(UserValidator.validateEmail(validEmail));
    }

    
    @Test
    public void testInvalidEmailMissingAtSymbol() {
        String invalidEmail = "lakshmipriya.com";
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }

    @Test
    public void testInvalidEmailMissingDomain() {
        String invalidEmail = "lakshmipriya@";
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }

  

    @Test
    public void testInvalidEmailNullInput() {
        String invalidEmail = null;
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }

    @Test
    public void testInvalidEmailEmptyInput() {
        String invalidEmail = "";
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }
}
