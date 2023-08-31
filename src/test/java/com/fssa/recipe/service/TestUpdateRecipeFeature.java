package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Recipe;

import com.fssa.recipe.service.exception.ServiceException;

 class TestUpdateRecipeFeature {

    @Test
    void testUpdateRecipeSuccess() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe("UpdatedRecipe", "Updated description",
                "Updated ingredients", "Updated instructions", "https://www.example.com/images/pasta-carbonara.jpg","veg",1);
        
        try {
            assertTrue(recipeService.updateRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
     void testUpdateRecipeInvalidData() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(null, "Updated description",
                "Updated ingredients", "Updated instructions", "updated_image_url");
        
        try {
            recipeService.updateRecipe(recipe);
            fail("Expected ServiceException");
        } catch (ServiceException e) {
           e.printStackTrace();
        }
    }

}
