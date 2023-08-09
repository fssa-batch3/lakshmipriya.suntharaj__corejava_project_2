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
    
    public static boolean validateName(String name) {
        if (name == null) {
            System.out.println("Invalid Name");
            return false;
        }
        return true;
    }

    public static boolean validateDescription(String description) {
        if (description == null) {
            System.out.println("Invalid description");
            return false;
        }
        return true;
    }

    public static boolean validateIngredients(String ingredients) {
        if (ingredients == null) {
            System.out.println("Invalid ingredients");
            return false;
        }
        return true;
    }

    public static boolean validateInstructions(String instructions) {
        if (instructions == null) {
            System.out.println("Invalid Instruction");
            return false;
        }
        return true;
    }

    public static boolean validateImageUrl(String imageUrl) {
        if (imageUrl == null) {
            System.out.println("Invalid imgurl");
            return false;
        }

        return true;
    }
}
