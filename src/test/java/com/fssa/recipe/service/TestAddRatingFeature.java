package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestAddRatingFeature {

	
	 @Test
	    public void testAddRatings() throws Exception {
	       
	       RatingsService yourService = new RatingsService();

	        
	        int recipeId =30 ;
	        int commentId = 33;
	        int userId = 22;
	        double ratingValue = 4;

	        
	        boolean result = yourService.addRatings(recipeId, commentId, userId, ratingValue);

	        assertTrue(result);
	    }
}
