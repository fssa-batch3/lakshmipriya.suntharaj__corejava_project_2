
package com.fssa.recipe.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.recipe.model.User;
import com.fssa.recipe.validation.exception.InvalidUserException;

public class UserValidator {
	public static void main(String[] args) throws InvalidUserException {
		User user = new User("pranaw", "mdpranaw@gmail.com", "Icodeu100%");

		System.out.println(validateUser(user));

	}

	public static boolean validateUser(User user) throws InvalidUserException {

		validateName(user.getUsername());
		validateEmail(user.getEmail());
		validatePassword(user.getPassword());
		return true;
	}

	public static boolean validateName(String name) throws InvalidUserException {
		if (name == null || name.trim().isEmpty()) {
			throw new InvalidUserException("Name cannot be null or empty");
		}
		return true;
	}

	public static boolean validatePassword(String password) throws InvalidUserException {
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[a-zA-Z]).{8,}$";
		if (Pattern.matches(regex, password)) {
			return true;
		} else {
			throw new InvalidUserException(
					"Password must contain one uppercase , one lowercase , one special character , length of eight character");
		}
	}

	public static boolean validateEmail(String email) throws InvalidUserException {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (Pattern.matches(regex, email)) {
			return true;
		} else {
			throw new InvalidUserException("Please enter appropriate email");
		}
	}
}