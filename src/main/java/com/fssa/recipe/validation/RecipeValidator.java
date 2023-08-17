package com.fssa.recipe.validation;

import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.validation.exception.InValidRecipeException;

public class RecipeValidator {

    public static boolean validateRecipe(Recipe recipe) throws InValidRecipeException {
        if (recipe != null && validateName(recipe.getName()) && validateDescription(recipe.getDescription())
                && validateIngredients(recipe.getIngredients()) && validateInstructions(recipe.getInstructions())
                && validateImageUrl(recipe.getImageUrl())) {
            return true;
        } else {
            throw new InValidRecipeException("Recipe details not valid");
        }
    }
    
    public static boolean validateName(String name) throws InValidRecipeException {
        if (name == null) {
            throw new InValidRecipeException("Invalid Name");
        }
        
        return true;
    }

    public static boolean validateDescription(String description) throws InValidRecipeException {
        if (description == null) {
            throw new InValidRecipeException("Invalid description");
        }
        return true;
    }

    public static boolean validateIngredients(String ingredients) throws InValidRecipeException {
        if (ingredients == null) {
            throw new InValidRecipeException("Invalid ingredients");
        }
        return true;
    }

    public static boolean validateInstructions(String instructions) throws InValidRecipeException {
        if (instructions == null) {
            throw new InValidRecipeException("Invalid Instruction");
        }
        return true;
    }

    public static boolean validateImageUrl(String imageUrl) throws InValidRecipeException {
        if (imageUrl == null) {
            throw new InValidRecipeException("Invalid imgurl");
        }
        return true;
    }
    
    public static boolean validateCategory(String category) throws InValidRecipeException {
        if (category == null) {
            throw new InValidRecipeException("Invalid Category");
        }
        return true;
    }
}
