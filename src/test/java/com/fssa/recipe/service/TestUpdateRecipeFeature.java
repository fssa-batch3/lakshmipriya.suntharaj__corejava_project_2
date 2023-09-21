package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Recipe;

import com.fssa.recipe.service.exception.ServiceException;

 class TestUpdateRecipeFeature {

    @Test
    void testUpdateRecipeSuccess() throws ClassNotFoundException {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(26,"pasta, " , "Chicken gravy is an authentic indian recipe made with lot of indian spices and masala.",
				"3/4 kg Chicken, oil, Cinnamon Stick,Cloves, Cardanom podes, Garlic, Black pepper, Salt",
				"1. Cook pasta according to package instructions.\n2. In a pan, fry bacon until crispy.\n3. In a bowl, whisk eggs, grated parmesan, cream, minced garlic, black pepper, and a pinch of salt.\n4. Drain cooked pasta and add it to the pan with bacon, then turn off the heat.\n5. Pour the egg mixture over the pasta and toss until coated in the sauce.\n6. Serve immediately with extra parmesan on top.",
				"https://www.myyellowplate.com/wp-content/uploads/2021/07/Best-Rajasthani-Non-Veg-Dishes-2.jpg", "Nonveg");
        
        try {
        	assertTrue(recipeService.updateRecipe(recipe));
        } catch (ServiceException e) { 
        	fail();
            e.printStackTrace();
            
        }
    }

    @Test
     void testUpdateRecipeInvalidData() throws ClassNotFoundException {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe(null, "Updated description",
                "Updated ingredients", "Updated instructions", "updated_image_url");
        
        try {
            recipeService.updateRecipe(recipe);
            fail();
        } catch (ServiceException e) {
           e.printStackTrace();
        }
    }

}
