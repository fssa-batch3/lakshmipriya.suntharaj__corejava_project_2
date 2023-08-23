package com.fssa.recipe.validation;

import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.validation.exception.InValidRecipeException;

public class RecipeValidator {

    public static boolean validateRecipe(Recipe recipe) throws InValidRecipeException {
        if (recipe != null && validateName(recipe.getName()) && validateDescription(recipe.getDescription())
                && validateIngredients(recipe.getIngredients()) && validateInstructions(recipe.getInstructions())
                && validateImageUrl(recipe.getImageUrl()) && validateCategory(recipe.getCategory()) ) {
            return true;
        } else {
            throw new InValidRecipeException("Recipe details not valid");
        }
    }
    
    public static boolean validateName(String name) throws InValidRecipeException {
        if (name == null || name.trim().isEmpty()) {
            throw new InValidRecipeException("Invalid Name");
        }
        
        return true;
    }

    public static boolean validateDescription(String description) throws InValidRecipeException {
        if (description == null || description.trim().isEmpty()) {
            throw new InValidRecipeException("Invalid description");
        }
        return true;
    }

    public static boolean validateIngredients(String ingredients) throws InValidRecipeException {
        if (ingredients == null || ingredients.trim().isEmpty()) {
            throw new InValidRecipeException("Invalid ingredients");
        }
        return true; 
    }

    public static boolean validateInstructions(String instructions) throws InValidRecipeException {
        if (instructions == null || instructions.trim().isEmpty()) {
            throw new InValidRecipeException("Invalid Instruction");
        }
        return true;
    }

    public static boolean validateImageUrl(String imageUrl) throws InValidRecipeException {
        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            throw new InValidRecipeException("Invalid imgurl");
        }

        String lowerCaseImageUrl = imageUrl.toLowerCase(); 

        if (!lowerCaseImageUrl.endsWith(".png") && !lowerCaseImageUrl.endsWith(".jpg")) {
            throw new InValidRecipeException("Invalid image file format. Only PNG and JPG formats allowed.");
        }

        return true;
    }
    
    public static boolean validateCategory(String category) throws InValidRecipeException {
        if (category == null || category.trim().isEmpty()) {
            throw new InValidRecipeException("Invalid Category");
        } else if (category.equals("veg")) {
            System.out.println("veg Category");
        } else if (category.equals("nonveg")) {
            System.out.println("nonveg Category");
        } else if (category.equals("snacks")) {
            System.out.println("snacks Category");
        } else {
            throw new InValidRecipeException("Unknown Category");
        }
		return false;
    }
}
