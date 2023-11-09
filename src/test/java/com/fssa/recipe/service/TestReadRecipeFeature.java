package com.fssa.recipe.service;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.service.exception.ServiceException;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

 class TestReadRecipeFeature {

    @Test
    void testGetAllRecipes() throws ServiceException {
        RecipeService recipeService = new RecipeService();
        List<Recipe> recipes = null;
        
        try {
            recipes = recipeService.getAllRecipes();
        
        assertNotNull(recipes); 
       
       
    }
    catch (Exception e) {
        
        fail("An exception occurred");
    } 
     
    }
    }
