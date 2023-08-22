package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.exception.InValidRecipeException;

 class TestValidaterecipeNameUsingNull {
@Test
	void testrecipevalidateDescriptionUsingNull() {
		
		try {
			assertFalse(RecipeValidator.validateName(null));
		} catch (InValidRecipeException e) {
			e.printStackTrace();
		}
	}

     


}
