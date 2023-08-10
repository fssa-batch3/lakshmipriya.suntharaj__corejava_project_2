package com.fssa.recipe.service.recipefeature;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.service.RecipeService;
import com.fssa.recipe.service.exception.ServiceException;

public class TestUpdateRecipeFeature {

    @Test
    public void testUpdateRecipeSuccess() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(200, "200th Updated Recipe", "Updated description",
                "Updated ingredients", "Updated instructions", "updated_image_url");
        
        try {
            assertTrue(recipeService.updateRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testUpdateRecipeInvalidData() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(1, null, "Updated description",
                "Updated ingredients", "Updated instructions", "updated_image_url");
        
        try {
            recipeService.updateRecipe(recipe);
            fail("Expected ServiceException");
        } catch (ServiceException e) {
           e.printStackTrace();
        }
    }

}