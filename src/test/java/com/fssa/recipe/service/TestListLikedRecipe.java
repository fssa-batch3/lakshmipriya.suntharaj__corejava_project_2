package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.service.exception.ServiceException;

public class TestListLikedRecipe {
	@Test
    void testGetLikedRecipesWithValidUserId() {
		LikeService likeService = new LikeService();
        // Arrange: Assuming user with ID 1 has liked recipes
        int userId = 13;

        // Act: Get the liked recipes
        List<Integer> likedRecipes = null;
		try {
			likedRecipes = likeService.getLikedRecipes(userId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Assert: Check that the likedRecipes list is not null and contains at least one recipe ID
        assertNotNull(likedRecipes);
        assertFalse(likedRecipes.isEmpty());
    }
	
	@Test
    void testGetLikedRecipesWithValidUserIdsyccess() {
		LikeService likeService = new LikeService();

        // Arrange: Assuming user with ID 1 has liked recipes
        int userId = 13;

        // Act: Get the liked recipes
        List<Integer> likedRecipes = null;
		try {
			likedRecipes = likeService.getLikedRecipes(userId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Assert: Check that the likedRecipes list is not empty
        assertTrue(!likedRecipes.isEmpty());
    }
}
