package com.fssa.recipe.service;



import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;


import com.fssa.recipe.model.User;
import com.fssa.recipe.service.exception.ServiceException;
 class TestLoginFeature {

	
	@Test
	 void loginSuccess() {
    UserService userService = new UserService();
   
    User user = new User("Zxcvbnm@1", "siva@gmail.com");
   
    try {
        assertTrue(userService.loginUser(user)); 
    } catch (ServiceException e) {
    	
    	
    }
    }

	@Test 

	
	 void testUserDoesnotExists() {
	    UserService userService = new UserService();
	    User user2 = new User( "Password@796","surya@gmail.com");
	    try {
	        assertFalse(userService.loginUser(user2)); //asexcepted
	    } catch (ServiceException e) {
	        
	    }
	}
	
	@Test 
	 void testNullInput() {
        UserService userService = new UserService();
        User user3 = new User(null, null);
        try {
			assertFalse(userService.loginUser(user3));
		} catch (ServiceException e) {
			
			
		}
    }

	
	
	

}