package com.fssa.recipe.service;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.service.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

public class TestReadRecipeFeature {

    @Test
    void testGetAllRecipes() throws ServiceException {
        RecipeService recipeService = new RecipeService();
        List<Recipe> recipes = null;
        
        try {
            recipes = recipeService.getAllRecipes();
        } catch (Exception e) {
            e.printStackTrace();
            fail("An exception occurred");
        }
        
        assertNotNull(recipes);
        assertFalse(recipes.isEmpty());
        assertEquals(5, recipes.size()); 
        Recipe firstRecipe = recipes.get(0);
        assertEquals("Pasta Carbonara", firstRecipe.getName());
        assertEquals("Delicious pasta dish with bacon and cream sauce.", firstRecipe.getDescription());
       
        for (Recipe recipe : recipes) {
            assertNotNull(recipe.getCategory());
            assertTrue(recipe.getCategory().equals("veg") || recipe.getCategory().equals("nonveg"));
        }
    }
}
