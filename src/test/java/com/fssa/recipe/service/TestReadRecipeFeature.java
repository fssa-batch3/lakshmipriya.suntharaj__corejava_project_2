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
        
        assertNotNull(recipes);
       
        for (Recipe recipe : recipes) {
          
        	System.out.println(recipe.toString());
        }
        System.out.println("Successfully viewwd all recipe");
    }
    catch (Exception e) {
        e.printStackTrace();
        fail("An exception occurred");
    }
     
    }
    }
