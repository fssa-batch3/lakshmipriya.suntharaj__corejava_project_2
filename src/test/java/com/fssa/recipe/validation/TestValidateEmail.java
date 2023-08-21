package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

 class TestValidateEmail {
 
    @Test
    void testValidEmail() {
        String validEmail = "lakshmipriya@example.com";
        assertTrue(UserValidator.validateEmail(validEmail));
    }

    
    @Test
    void testInvalidEmailMissingAtSymbol() {
        String invalidEmail = "lakshmipriya.com";
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }

    @Test
 void testInvalidEmailMissingDomain() {
        String invalidEmail = "lakshmipriya@";
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }

  

    @Test
    void testInvalidEmailNullInput() {
        String invalidEmail = null;
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }

    @Test
    void testInvalidEmailEmptyInput() {
        String invalidEmail = "";
        assertFalse(UserValidator.validateEmail(invalidEmail));
    }
}
