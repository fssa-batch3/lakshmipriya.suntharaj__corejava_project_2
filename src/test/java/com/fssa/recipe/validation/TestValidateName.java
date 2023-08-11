package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.UserValidator;

 class TestValidateName { 

    @Test
    void testValidName() {
        String validName = "LakshmiPriya";
        assertTrue(UserValidator.validateName(validName));
    }

    @Test
    void testInvalidNameTooShort() {
        String invalidName = "Ak"; // Name must be at least 3 characters long
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    void testInvalidNameTooLong() {
        String invalidName = "HIIIGuYYYYYssEPPDiIRUKINgaRATHIMALASAPTINGALA"; // Name cannot be longer than 29 characters
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    void testInvalidNameContainsSpecialCharacters() {
        String invalidName = "User@name"; // Name can only contain letters, digits, and underscore
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    void testInvalidNameStartsWithDigit() {
        String invalidName = "22user"; // Name cannot start with a digit
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    void testInvalidNameNullInput() {
        String invalidName = null;
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
 void testInvalidNameEmptyInput() {
        String invalidName = "";
        assertFalse(UserValidator.validateName(invalidName));
    }
}
