package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.exception.InValidRecipeException;

public class Testrecipedescription {

	@Test
void testrecipeDescriptionUsingNull() {
		
		try {
			assertFalse(RecipeValidator.validateDescription(null));
		} catch (InValidRecipeException e) {
			e.printStackTrace();
		}
	}
}
