package com.fssa.recipe.service.User;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.User;
import com.fssa.recipe.service.UserService;
import com.fssa.recipe.service.exception.ServiceException;

public class TestRegisterFeature {



	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user1 = new User("vinit.gore@ctr.freshworks.com", "Vinit", "Zxcvbnm@1");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistrationUsernameEmpty() {

		UserService userService = new UserService();
		User user1 = new User("vinit.gore@ctr.freshworks.com", "", "Zxcvbnm@1");
		try {
		userService.registerUser(user1);
		fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}

	@Test
	public void testUserNull() {
		UserService userService = new UserService();
		User user1 = null;
		try {
			userService.registerUser(user1);
			fail();
		} catch (ServiceException e) {
			e.printStackTrace();

		}
	}
	public void testDuplicateUserRegistration() {
	    UserService userService = new UserService();
	    User user1 = new User("vinit.gore@ctr.freshworks.com", "Vinit", "Zxcvbnm@1");
	    User user2 = new User("vinit.gore@ctr.freshworks.com", "Vinit", "Zxcvbnm@1");
	    try {
	        userService.registerUser(user1);
	        userService.registerUser(user2);
	        fail();
	       
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	
	
	
}



