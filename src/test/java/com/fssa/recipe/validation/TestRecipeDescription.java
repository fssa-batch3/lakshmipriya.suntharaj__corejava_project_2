package com.fssa.recipe.validation;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.exception.InValidRecipeException;

 class TestRecipeDescription {

	@Test
	 void testValidDescription() throws InValidRecipeException {
	    assertTrue(RecipeValidator.validateDescription("This is a delicious recipe."));
	}

	@Test
	 void testValidDescriptionWithWhiteSpace() throws InValidRecipeException {
	    assertTrue(RecipeValidator.validateDescription("   Description with spaces   "));
	}

}
