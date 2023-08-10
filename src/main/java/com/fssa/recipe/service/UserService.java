package com.fssa.recipe.service;

import java.sql.SQLException;

import com.fssa.recipe.dao.*;
import com.fssa.recipe.model.*;
import com.fssa.recipe.service.exception.ServiceException;
import com.fssa.recipe.validation.*;
import com.fssa.recipe.validation.exception.InvalidUserException;

public class UserService {

	public boolean registerUser(User user) throws ServiceException {
		UserDAO userDAO = new UserDAO();

		try {
			UserValidator.validateUser(user);

			return userDAO.register(user);
		} catch (InvalidUserException | SQLException e) {
			throw new ServiceException(e);
		}

	}

	public boolean loginUser(User user) throws ServiceException {

		try {
			UserValidator.validateEmail(user.getEmail());
			UserValidator.validatePassword(user.getPassword());

			UserDAO userDAO = new UserDAO();
			if (userDAO.login(user)) {
				System.out.println(user.getEmail() + " Successfully logged in");
				return true;
			} 
		} catch (Exception e) {
			throw new ServiceException (e.getMessage());
		}
		return false;
       
	}

// update user
	
	public boolean updateUser(User user) throws ServiceException {
	    try {
	        
	        UserValidator.validateEmail(user.getEmail());
	        UserValidator.validatePassword(user.getPassword());

	        UserDAO userDAO = new UserDAO();

	        
	        if (userDAO.updateUser(user)) {
	            System.out.println(user.getEmail() + " information updated successfully");
	            return true;
	        } 
	    } catch (Exception e) {
	        throw new ServiceException(e.getMessage());
	    }
	    return false;
	}



}