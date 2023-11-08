package com.fssa.recipe.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.recipe.dao.RecipeDAO;
import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.service.exception.ServiceException;
import com.fssa.recipe.validation.RecipeValidator;
import com.fssa.recipe.validation.exception.InValidRecipeException;

public class RecipeService {

	public boolean addRecipe(Recipe recipe) throws ServiceException, ClassNotFoundException {
		try {
			RecipeValidator.validateRecipe(recipe);
			RecipeDAO recipeDAO = new RecipeDAO();
			return recipeDAO.addRecipe(recipe);
		} catch (InValidRecipeException | SQLException e) {
			throw new ServiceException(e);
		}
	}

	public List<Recipe> getAllRecipes() throws ServiceException, ClassNotFoundException {
		try {
			
			RecipeDAO recipeDAO = new RecipeDAO();
			List<Recipe> recipedetail = recipeDAO.getAllRecipes();
			
			return recipedetail;
		} catch (SQLException e) { 
			throw new ServiceException(e);
		}
	}

	public boolean updateRecipe(Recipe recipe) throws ServiceException, ClassNotFoundException {
		try {
			RecipeValidator.validateRecipe(recipe); 
			RecipeDAO recipeDAO = new RecipeDAO();
			return recipeDAO.updateRecipe(recipe);
		} catch (InValidRecipeException | SQLException e) {
			throw new ServiceException(e);
		}
	}

	public boolean deleteRecipe(int recipeId) throws ServiceException, ClassNotFoundException {
		try {
			RecipeDAO recipeDAO = new RecipeDAO();
			return recipeDAO.deleteRecipe(recipeId);
		} catch (SQLException e) {
			throw new ServiceException(e);
		}
	}

	public Recipe findRecipeById(int recipeId) throws ServiceException {
		try {
			RecipeDAO recipeDAO = new RecipeDAO();

			return recipeDAO.findRecipeById(recipeId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public Recipe viewRecipeById(int recipeId) throws ServiceException {
		try {
			RecipeDAO recipeDAO = new RecipeDAO();

			return recipeDAO.findRecipeById(recipeId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	
	

	public Recipe findRecipeByName(String name) throws ServiceException {
		try {
			RecipeDAO recipeDAO = new RecipeDAO();

			return recipeDAO.findRecipeByName(name);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
	}
		
		public List<Recipe> listRecipesByUserId(int Userid) throws ServiceException {
		    RecipeDAO recipeDAO = new RecipeDAO();
 
		    try {
		        return recipeDAO.listRecipesByUserId(Userid);
		    } catch (DAOException e) {
		        throw new ServiceException(e);
		    }
		}
	
		public List<Recipe> listRecipesByCategory(String category) throws ServiceException {
		    RecipeDAO recipeDAO = new RecipeDAO();
 
		    try {
		        return recipeDAO.listRecipesByCategory(category);
		    } catch (DAOException e) {
		        throw new ServiceException(e);
		    }
		}
	
		
		public List<Recipe> searchRecipesByName(String searchQuery) throws ServiceException {
	        try {
	        	
	        	RecipeDAO recipeDAO = new RecipeDAO();
	            return recipeDAO.searchRecipesByName(searchQuery);
	        } catch (DAOException e) {
	            throw new ServiceException(e);
	        }
	    }
		
		
		public Recipe getRecipeById(int recipeId) throws ServiceException {
	        try {
	        	RecipeDAO recipeDAO = new RecipeDAO();
	            return recipeDAO.getRecipeById(recipeId);
	        } catch (ClassNotFoundException | SQLException e) {
	            throw new ServiceException(e);
	        }
	       
	    }

		
}
