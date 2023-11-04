package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.service.exception.ServiceException;
 class TestListLikedRecipe {
	@Test
    void testGetLikedRecipesWithValidUserId() {
		LikeService likeService = new LikeService();
        
        int userId = 13;

        
        List<Integer> likedRecipes = null;
		try {
			likedRecipes = likeService.getLikedRecipes(userId);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}

       
        assertNotNull(likedRecipes);
        assertFalse(likedRecipes.isEmpty());
    }
	
	@Test
    void testGetLikedRecipesWithValidUserIdsyccess() {
		LikeService likeService = new LikeService();

        
        int userId = 13;

        
        List<Integer> likedRecipes = null;
		try {
			likedRecipes = likeService.getLikedRecipes(userId);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}

         assertTrue(!likedRecipes.isEmpty());
    }
}
