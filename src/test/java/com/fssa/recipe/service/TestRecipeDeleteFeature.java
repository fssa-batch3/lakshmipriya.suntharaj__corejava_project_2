package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


import com.fssa.recipe.service.exception.ServiceException;

class TestRecipeDeleteFeature {

	@Test
	void testDeleteRecipeSuccess() {
		RecipeService RecipeService = new RecipeService();

		int recipeIdToDelete = 3;
		try {
			assertTrue(RecipeService.deleteRecipe(recipeIdToDelete));
			System.out.println("recipe deleted successfully");

		} catch (ServiceException e) { 
			e.printStackTrace();
		}
	}

	
	
}