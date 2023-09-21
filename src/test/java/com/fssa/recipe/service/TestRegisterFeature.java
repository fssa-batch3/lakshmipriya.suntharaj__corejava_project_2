package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.User;

import com.fssa.recipe.service.exception.ServiceException;

class TestRegisterFeature {
@Test
	 void testRegisterSuccess() throws ClassNotFoundException {
			User user1 = new User( "hema", "hema1@gmail.com","Dahrun@456");
			UserService  UserService = new UserService();
			try {
				assertTrue(UserService.registerUser(user1)); 
			} catch (ServiceException e) {
				e.printStackTrace();  
				fail(); 
			}
		}
 



	@Test
	void testUserNull() throws ClassNotFoundException {
		UserService userService = new UserService();
		User user1 = null;
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	void testDuplicateUserRegistration() throws ClassNotFoundException {
		UserService userService = new UserService();
		User user1 = new User("Vinit", "vinit.gore@ctr.freshworks.com", "Zxcvbnm@1");
		User user2 = new User("Vinit", "vinit.gore@ctr.freshworks.com", "Zxcvbnm@1");

		User[] usersToRegister = { user1, user2 };

		try {
			for (User user : usersToRegister) {
				userService.registerUser(user);
			}
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
