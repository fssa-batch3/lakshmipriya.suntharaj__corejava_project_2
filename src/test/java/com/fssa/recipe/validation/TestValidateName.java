package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.UserValidator;
import com.fssa.recipe.validation.exception.InvalidUserException;

 class TestValidateName { 

    @Test
    void testValidName() {
        String validName = "Lakshmipriya";
        try {
			assertTrue(UserValidator.validateName(validName));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    void testInvalidSpaceContain() {
        String invalidName = "   "; // Name must be at least 3 characters long
        try {
			assertFalse(UserValidator.validateName(invalidName));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    void testInvalidNameTooLong() {
        String invalidName = "HIIIGuYYYYYssEPPDiIRUKINgaRATHIMALASAPTINGALA33"; // Name cannot be longer than 29 characters
        try {
			assertTrue(UserValidator.validateName(invalidName));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Test
    void testInvalidNameNullInput() {
        String invalidName = null; // Name can only contain letters, digits, and underscore
        try {
			assertFalse(UserValidator.validateName(invalidName));
		} catch (InvalidUserException e) {
			
			e.printStackTrace();
		}
    }

    @Test
    void testInvalidNameStartsWithDigit() {
        String invalidName = "22user"; // Name cannot start with a digit
        try {
			assertTrue(UserValidator.validateName(invalidName));
		} catch (InvalidUserException e) {
			
			e.printStackTrace();
		}
    }

   
    @Test
 void testInvalidNameEmptyInput() {
        String invalidName = " ";
        try {
			assertFalse(UserValidator.validateName(invalidName));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
