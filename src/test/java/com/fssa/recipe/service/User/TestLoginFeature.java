package com.fssa.recipe.service.User;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.*;
import com.fssa.recipe.service.UserService;
import com.fssa.recipe.service.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.assertFalse;
public class TestLoginFeature {

	
	@Test
	 void loginSuccess() {
    UserService userService = new UserService();
   
    User user = new User("Zxcvbnm@1", "Mullai2@gmail.com");
   
    try {
        assertTrue(userService.loginUser(user)); 
    } catch (ServiceException e) {
    	e.printStackTrace();
    	fail();
    }
    }

	@Test 

	
	 void testUserDoesnotExists() {
	    UserService userService = new UserService();
	    User user2 = new User( "Password@796","surya@gmail.com");
	    try {
	        assertFalse(userService.loginUser(user2)); // Expecting login to fail, so assertFalse should return true.
	    } catch (ServiceException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
	 void testNullInput() {
        UserService userService = new UserService();
        User user3 = new User(null, null);
        try {
			assertFalse(userService.loginUser(user3));
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
    }


}