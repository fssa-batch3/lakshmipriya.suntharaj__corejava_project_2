package com.fssa.recipe.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.fssa.recipe.model.User;
import com.fssa.recipe.validation.exception.InvalidUserException;

public class UserValidator {
	public static boolean validateUser(User user) throws InvalidUserException {
		if (user != null &&  validatePassword(user.getPassword())
				) {
			return true;
		} else {
			throw new InvalidUserException("User details not valid");
		}
	}

	 public static boolean validateName(String name) {
	        if (name == null) {
	            System.out.println("The user name is null.");
	            return false;
	        }

	        String regex = "^[A-Za-z]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(name);

	        if (matcher.matches()) {
	            System.out.println("The user name is valid.");
	            return true;
	        } else {
	            System.out.println("The user name is not valid.");
	            return false;
	        }
	    }

	public static boolean validatePassword(String password) {
		boolean match = true;
		if (password == null) 
			return false;
		String pattern_string = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
		match = Pattern.matches(pattern_string, password);
		if (match) {
			System.out.println("Valid password.");
		} else {
			System.out.println("Invalid password.");
		}
		return match;
	}

	public static boolean validateEmail(String email) {
		boolean isMatch = true;
		if (email == null)
			return false;
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		isMatch = Pattern.matches(regex, email);
		if (isMatch) {
			System.out.println("The email address is: Valid");
		} else {
			System.out.println("The email address is: Invalid");
		}
		return isMatch;
	}
	
}
