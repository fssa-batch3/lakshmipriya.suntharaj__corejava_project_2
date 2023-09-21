package com.fssa.recipe.service;

import com.fssa.recipe.dao.UserDAO;
import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.User;
import com.fssa.recipe.service.exception.ServiceException;
import com.fssa.recipe.validation.UserValidator;
import com.fssa.recipe.validation.exception.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {

			UserValidator.validateUser(user);
			return userDAO.register(user);
		} catch (InvalidUserException | ClassNotFoundException | DAOException e) {
			throw new ServiceException(e);
		}

	}

	public boolean loginUser(User user) throws ServiceException {

		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword(), user.getConfirmpassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user)) {

				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return false;

	}

// update user

	public boolean updateUser(User user, String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			// Check if the user is null
			if (user == null) {
				throw new InvalidUserException("User is null while updating");
			}

			// Validate the user's details using the UserValidator

			return userDAO.updateUser(user);
		} catch (InvalidUserException | DAOException e) {
			throw new ServiceException(e);
		}
	}

	public User findUserByUserid(int userid) throws ServiceException {
		UserDAO userDAO = new UserDAO();
		try {

			return userDAO.findUserByUserid(userid);
		} catch (Exception e) {
			throw new ServiceException("Failed to find user by Userid");
		}
	}

	
	public User findUserByEmail(String email) throws ServiceException {
		UserDAO userDAO = new UserDAO();
        try {
        	
            return userDAO.getUserByEmail(email);
        } catch (DAOException e) {
            throw new ServiceException("Error getting user by email");
        }
    }
	
	
	
	public static void main1(String[] args) {
        UserService userService = new UserService();

      
        String emailToFind = "muthubro@gmail.com";

        try {
            User foundUser = userService.findUserByEmail(emailToFind);
            if (foundUser != null) {
                System.out.println("User found:");
                System.out.println("Name: " + foundUser.getUsername());
                System.out.println("Email: " + foundUser.getEmail());
                
            } else {
                System.out.println("User not found for email: " + emailToFind);
            }
        } catch (ServiceException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
}