package com.fssa.recipe.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.recipe.model.User;
import com.fssa.recipe.validation.exception.InvalidUserException;

public class UserValidator {

    public static boolean validateUser(User user) throws InvalidUserException {
        if (user != null &&
            validateName(user.getUsername()) &&
            validatePassword(user.getPassword()) &&
            validateEmail(user.getEmail())) {
            return true;
        } else {
            throw new InvalidUserException("User details not valid");
        }
    }

    public static boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("The user name is null or empty.");
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
        if (password == null) {
            System.out.println("The password is null.");
            return false;
        }

        String patternString = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=.*[^\\s]).{8,}$";
        boolean match = Pattern.matches(patternString, password);

        if (match) {
            System.out.println("Valid password.");
        } else {
            System.out.println("Invalid password.");
        }
        return match;
    }

    public static boolean validateEmail(String email) {
        if (email == null) {
            System.out.println("The email address is null.");
            return false;
        }

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isMatch = Pattern.matches(regex, email);

        if (isMatch) {
            System.out.println("The email address is: Valid");
        } else {
            System.out.println("The email address is: Invalid");
        }
        return isMatch;
    }
}
