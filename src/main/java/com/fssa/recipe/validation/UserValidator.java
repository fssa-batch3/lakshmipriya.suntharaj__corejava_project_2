
package com.fssa.recipe.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.recipe.model.User;
import com.fssa.recipe.validation.exception.InvalidUserException;

public class UserValidator {

	public static boolean validateUser(User user) throws InvalidUserException {
		if (user != null &&
	             validateName(user.getUsername()) &&
				validatePassword(user.getPassword())&&
		        validateEmail (user.getEmail())) 
		{
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}   
	}

	public static boolean validateName(String name) throws InvalidUserException {
	    

	    if (name!=null ) {
	        return true;
	    } else {
	        throw new InvalidUserException("Name cannot be null");
	    }
	}


	public static boolean validatePassword(String password) throws InvalidUserException {
		String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";

		if (Pattern.matches(patternString, password)) {
			return true;
		} else {
			throw new InvalidUserException(
					"Password must contain one uppercase , one lowercase , one special character , length of eight character");
		}
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		String regex = "^.*@.*\\..*$";
		if (Pattern.matches(regex, email)) {
			return true;
		} else {
			throw new InvalidUserException("Please enter appropriate email");
		}
	}
}