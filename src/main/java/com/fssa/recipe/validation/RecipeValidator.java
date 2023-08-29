package com.fssa.recipe.validation;

import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.validation.exception.InValidRecipeException;

public class RecipeValidator {

	public static boolean validateRecipe(Recipe recipe) throws InValidRecipeException {
	    if (recipe == null) {
	        throw new InValidRecipeException("Recipe is null");
	    }

	    if (!validateName(recipe.getName())) {
	        throw new InValidRecipeException("Name is not valid");
	    }

	    if (!validateDescription(recipe.getDescription())) {
	        throw new InValidRecipeException("Description is not valid");
	    }

	    if (!validateIngredients(recipe.getIngredients())) {
	        throw new InValidRecipeException("Ingredients are not valid");
	    }

	    if (!validateInstructions(recipe.getInstructions())) {
	        throw new InValidRecipeException("Instructions are not valid");
	    }

	    if (!validateImageUrl(recipe.getImageUrl())) {
	        throw new InValidRecipeException("Image URL is not valid");
	    }

//	    if (!validateCategory(recipe.getCategory())) {
//	        throw new InValidRecipeException("Category is not valid");
//	    }

	    return true;
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
    
    public static void validateCategory(String category) throws InValidRecipeException {
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
		
    }
}
