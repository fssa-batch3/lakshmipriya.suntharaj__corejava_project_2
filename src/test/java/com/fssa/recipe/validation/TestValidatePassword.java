package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.exception.InvalidUserException;




 class TestValidatePassword {
@Test
	 void testValidPassword() { 

		try {
			assertTrue(UserValidator.validatePassword("Password@123"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} 

	@Test
	 void testInvalidPasswordWithoutSpecialCharacters() {
		try {
			assertFalse(UserValidator.validatePassword("Password123"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	 void testInvalidPasswordWithoutNumbers() {
		try {
			assertFalse(UserValidator.validatePassword("Password@"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
 void testInvalidPasswordWithoutCapitalLetters() {
		try {
			assertFalse(UserValidator.validatePassword("password123"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidPasswordWithoutSmallLetters() {
		try {
			assertFalse(UserValidator.validatePassword("PASSWORD@123"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
void testInvalidPasswordShorterLength() {
		try {
			assertFalse(UserValidator.validatePassword("Pas@123"));
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	

}