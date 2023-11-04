package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.service.exception.ServiceException;

public class TestDislikeFeature {

	@Test
	void testDislikeRecipeSuccess() throws ClassNotFoundException {
		LikeService likeservice = new LikeService();

		int recipeIdToDelete = 30;
		int userIdToDelete = 30;
		try {
			assertTrue(likeservice.disLike(userIdToDelete, recipeIdToDelete));
			System.out.println("recipe disliked successfully");

		} catch (ServiceException e) { 
			
			fail();
			
		}
	}
	
}
