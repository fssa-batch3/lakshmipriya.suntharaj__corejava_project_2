package com.fssa.recipe.service;

import java.sql.SQLException;
import java.util.List;
//import java.util.List;

import com.fssa.recipe.dao.RecipeDAO;
import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.service.exception.ServiceException;
import com.fssa.recipe.validation.RecipeValidator;
import com.fssa.recipe.validation.exception.InValidRecipeException;

public class RecipeService {

    // Add new recipe
    public boolean addRecipe(Recipe recipe) throws ServiceException {
        try {
            RecipeValidator.validateRecipe(recipe);
            RecipeDAO recipeDAO = new RecipeDAO();
            return recipeDAO.addRecipe(recipe);
        } catch (InValidRecipeException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    // Get recipe by ID
    public Recipe getRecipeById(int recipeId) throws ServiceException {
        try {
            RecipeDAO recipeDAO = new RecipeDAO();
            return recipeDAO.getRecipeById(recipeId);
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    // Update recipe
    public boolean updateRecipe(Recipe recipe) throws ServiceException {
        try {
            RecipeValidator.validateRecipe(recipe);

            RecipeDAO recipeDAO = new RecipeDAO();
            return recipeDAO.updateRecipe(recipe);
        } catch (InValidRecipeException | SQLException e) {
            throw new ServiceException(e);
        }
    }

    // Delete recipe
    public boolean deleteRecipe(int recipeId) throws ServiceException {
        try {
            RecipeDAO recipeDAO = new RecipeDAO();
            return recipeDAO.deleteRecipe(recipeId);
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }

    // Get a list of all recipes
    public List<Recipe> getAllRecipes() throws ServiceException {
        try {
            RecipeDAO recipeDAO = new RecipeDAO();
            return recipeDAO.getAllRecipes();
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
    }
}
