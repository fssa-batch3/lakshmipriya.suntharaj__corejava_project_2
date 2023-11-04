package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.service.exception.ServiceException;

class TestRecipeDeleteFeature {

	@Test
	void testDeleteRecipeSuccess() throws ClassNotFoundException {
		RecipeService RecipeService = new RecipeService();

		int recipeIdToDelete = 25;
		try {
			assertTrue(RecipeService.deleteRecipe(recipeIdToDelete));
			

		} catch (ServiceException e) {
			fail();
		}
	}

}