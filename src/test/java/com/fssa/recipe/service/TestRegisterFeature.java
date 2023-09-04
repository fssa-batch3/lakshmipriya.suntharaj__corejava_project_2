package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.User;

import com.fssa.recipe.service.exception.ServiceException;

class TestRegisterFeature {

	 @Test
	    public void testRegisterValidUser() {
	      UserService registerService = new UserService();
	      
	        User validUser = new User("Vinit", "vanitha@gmail.com", "Zxcvbnm@123");

	        try {
	            boolean result = registerService.registerUser(validUser);
	            assertTrue(result); 
	        } catch (ServiceException e) {
	            fail("Exception should not be thrown for a valid user");
	        }
	    }



	@Test
	void testRegistrationUsernameEmpty() {

		UserService userService = new UserService();
		User user1 = new User(" ", "vinit@gamil.com", "Zxcvbnm@1");
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	void testUserNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	void testDuplicateUserRegistration() {
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
