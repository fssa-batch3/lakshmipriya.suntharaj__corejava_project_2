package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.util.Utilities;

public class RecipeDAO {

	
	
	
	
//add recipe to the database

	/**
	 * Adds a new recipe to the database.
	 *
	 * @param recipe The Recipe object containing the recipe's information.
	 * @return True if the recipe was successfully added, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	
	
	public boolean addRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {
		int rows = 0;
		String query = "INSERT INTO recipes (name, description, ingredients, instructions, imageUrl, Category,Userid) VALUES ( ?, ?, ?, ?, ? ,?,?)";
		try (Connection connection = Utilities.getConnection(); 

				PreparedStatement pmt = connection.prepareStatement(query))

		{

			pmt.setString(1, recipe.getName());
			pmt.setString(2, recipe.getDescription());
			pmt.setString(3, recipe.getIngredients());
			pmt.setString(4, recipe.getInstructions());
			pmt.setString(5, recipe.getImageUrl());
			pmt.setString(6, recipe.getCategory());
			pmt.setInt(7, recipe.getUserid());
           
			rows = pmt.executeUpdate();
		}

		return rows == 1;
	}

// list recipes 
	
	
	/**
	 * Retrieves a list of all non-deleted recipes from the database.
	 *
	 * @return A list of Recipe objects containing recipe information.
	 * @throws SQLException If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	public List<Recipe> getAllRecipes() throws SQLException, ClassNotFoundException {
		List<Recipe> recipes = new ArrayList<>();

		String query = "SELECT * FROM recipes WHERE isDeleted = 0 ORDER BY recipeId DESC";
		try (Connection connection = Utilities.getConnection(); 
				PreparedStatement pmt = connection.prepareStatement(query);
				ResultSet rs = pmt.executeQuery()) {

			while (rs.next()) {
				
                int recipeId = rs.getInt("recipeId");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String ingredients = rs.getString("ingredients");
				String instructions = rs.getString("instructions");
				String imageUrl = rs.getString("imageUrl");
				String catagory = rs.getString("Category");
				Recipe recipe = new Recipe(recipeId,name, description, ingredients, instructions, imageUrl, catagory);
				recipes.add(recipe);
			}
		}

		return recipes;
	}

	// Update recipe in DB
	
	/**
	 * Retrieves a list of all non-deleted recipes from the database.
	 *
	 * @return A list of Recipe objects containing recipe information.
	 * @throws SQLException If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	
	
	public   Recipe findRecipeById(int recipeId) throws DAOException {
		final String SELECTQUERY = "SELECT * FROM recipes WHERE recipeId = ?";

		
		try (Connection connection = Utilities.getConnection();
				PreparedStatement pmt = connection.prepareStatement(SELECTQUERY)) {

			pmt.setInt(1, recipeId);

			try (ResultSet rs = pmt.executeQuery()) {
				Recipe recipe = new Recipe();
				if (rs.next()) {
					
					recipe.setRecipeId(rs.getInt("recipeId"));
					recipe.setName(rs.getString("name"));
					recipe.setDescription(rs.getString("description"));
					recipe.setIngredients(rs.getString("ingredients"));
					recipe.setInstructions(rs.getString("instructions"));
					recipe.setImageUrl(rs.getString("imageUrl"));
					recipe.setCategory(rs.getString("category"));
					return recipe;
				}
				else {
					throw new DAOException("Recipie with"+recipeId+"id is not found ");
				}
				
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new DAOException(e);
		}
		

		
	}
	
	
	
	public boolean updateRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {
		String query = "UPDATE recipes SET name = ?, description = ?, ingredients = ?, instructions = ?, "
				+ "imageUrl = ? ,"+ " Category = ? WHERE recipeId = ?";
		try (Connection connection = Utilities.getConnection(); 

				PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setString(1, recipe.getName());
			pmt.setString(2, recipe.getDescription());
			pmt.setString(3, recipe.getIngredients());
			pmt.setString(4, recipe.getInstructions());
			pmt.setString(5, recipe.getImageUrl());
			pmt.setString(6, recipe.getCategory());
			pmt.setInt(7, recipe.getRecipeId());
			int rows = pmt.executeUpdate();

			return rows == 1;
		}

	}
	
	
	public Recipe findRecipeByName(String recipeName) throws DAOException {
	    final String SELECT_QUERY = "SELECT * FROM recipes WHERE name = ?";

	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(SELECT_QUERY)) {

	        pmt.setString(1, recipeName);

	        try (ResultSet rs = pmt.executeQuery()) {
	            Recipe recipe = new Recipe();
	            if (rs.next()) {
	                recipe.setRecipeId(rs.getInt("recipeId"));
	                recipe.setName(rs.getString("name"));
	                recipe.setDescription(rs.getString("description"));
	                recipe.setIngredients(rs.getString("ingredients"));
	                recipe.setInstructions(rs.getString("instructions"));
	                recipe.setImageUrl(rs.getString("imageUrl"));
	                recipe.setCategory(rs.getString("category"));
	                return recipe;
	            } else {
	                throw new DAOException("Recipe with name '" + recipeName + "' is not found");
	            }

	        }
	    } catch (SQLException | ClassNotFoundException e) {
	        throw new DAOException(e);
	    }
	}


	// Delete recipe from DB
	
	/**
	 * Marks a recipe as deleted in the database.
	 *
	 * @param recipeId The ID of the recipe to be marked as deleted.
	 * @return True if the recipe was successfully marked as deleted, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws ClassNotFoundException If the database driver class is not found.
	 */
	
	
	public boolean deleteRecipe(int recipeId) throws SQLException, ClassNotFoundException {
		String query = "UPDATE  recipes SET isDeleted = ? WHERE RecipeId = ?";
		try (Connection connection = Utilities.getConnection();
		    PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true);
			pmt.setInt(2, recipeId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}
	
	
	public List<Recipe> listRecipesByUserId(int Userid) throws DAOException {
	    String query = "SELECT * FROM recipes WHERE Userid = ? AND isDeleted=0";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setInt(1, Userid);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        List<Recipe> recipes = new ArrayList<>();

	        while (resultSet.next()) {
	            Recipe recipes1 = new Recipe();
	            recipes1.setRecipeId(resultSet.getInt("recipeId"));
	            recipes1.setName(resultSet.getString("name"));
	            recipes1.setDescription(resultSet.getString("description"));
	            recipes1.setImageUrl(resultSet.getString("imageUrl"));
	            recipes1.setIngredients(resultSet.getString("ingredients"));
	            recipes1.setInstructions(resultSet.getString("instructions"));
	            recipes1.setCategory(resultSet.getString("category"));
	            recipes1.setUserid(resultSet.getInt("Userid"));

	            recipes.add(recipes1);
	        }

	        return recipes;

	    } catch (SQLException | ClassNotFoundException e) {
	        throw new DAOException(e);
	    }
	}

	
	
	public List<Recipe> listRecipesByCategory(String category) throws DAOException {
	    String query = "SELECT * FROM recipes WHERE Category = ? AND isDeleted = 0";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, category);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        List<Recipe> recipes = new ArrayList<>();

	        while (resultSet.next()) {
	            Recipe recipe = new Recipe();
	            recipe.setRecipeId(resultSet.getInt("recipeId"));
	            recipe.setName(resultSet.getString("name"));
	            recipe.setDescription(resultSet.getString("description"));
	            recipe.setImageUrl(resultSet.getString("imageUrl"));
	            recipe.setIngredients(resultSet.getString("ingredients"));
	            recipe.setInstructions(resultSet.getString("instructions"));
	            recipe.setCategory(resultSet.getString("Category"));
	            recipe.setUserid(resultSet.getInt("Userid"));

	            recipes.add(recipe);
	        }

	        return recipes;

	    } catch (SQLException | ClassNotFoundException e) {
	        throw new DAOException(e);
	    }
	}


	public List<Recipe> searchRecipesByName(String searchQuery) throws DAOException {
	    String query = "SELECT * FROM recipes WHERE isDeleted = 0 AND name LIKE ?";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        String likeQuery = "%" + searchQuery + "%";
	        preparedStatement.setString(1, likeQuery);
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        List<Recipe> recipes = new ArrayList<>();

	        while (resultSet.next()) {
	            Recipe recipe = new Recipe();
	            recipe.setRecipeId(resultSet.getInt("recipeId"));
	            recipe.setName(resultSet.getString("name"));
	            recipe.setDescription(resultSet.getString("description"));
	            recipe.setImageUrl(resultSet.getString("imageUrl"));
	            recipe.setIngredients(resultSet.getString("ingredients"));
	            recipe.setInstructions(resultSet.getString("instructions"));
	            recipe.setCategory(resultSet.getString("Category"));
	            recipe.setUserid(resultSet.getInt("Userid"));

	            recipes.add(recipe);
	        }

	        return recipes; 

	    } catch (SQLException | ClassNotFoundException e) {
	        throw new DAOException(e);
	    }
	}

	
	
	
	public List<Recipe> searchRecipesByIngredient(String searchQuery) throws DAOException {
	    String query = "SELECT * FROM recipes WHERE isDeleted = 0 AND ingredients LIKE ?";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        String likeQuery = "%" + searchQuery + "%";
	        preparedStatement.setString(1, likeQuery);
	        
	        ResultSet resultSet = preparedStatement.executeQuery();
	        List<Recipe> recipes = new ArrayList<>();

	        while (resultSet.next()) {
	            Recipe recipe = new Recipe();
	            recipe.setRecipeId(resultSet.getInt("recipeId"));
	            recipe.setName(resultSet.getString("name"));
	            recipe.setDescription(resultSet.getString("description"));
	            recipe.setImageUrl(resultSet.getString("imageUrl"));
	            recipe.setIngredients(resultSet.getString("ingredients"));
	            recipe.setInstructions(resultSet.getString("instructions"));
	            recipe.setCategory(resultSet.getString("Category"));
	            recipe.setUserid(resultSet.getInt("Userid"));

	            recipes.add(recipe);
	        }

	        return recipes; 

	    } catch (SQLException | ClassNotFoundException e) {
	        throw new DAOException(e);
	    }
	}

	
	

	


	
	public Recipe getRecipeById(int recipeId) throws SQLException, ClassNotFoundException {
	    Recipe recipe = null;
	    String query = "SELECT * FROM recipes WHERE recipeId = ? AND isDeleted = 0";

	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {

	        pmt.setInt(1, recipeId);
	        try (ResultSet rs = pmt.executeQuery()) {
	            if (rs.next()) {
	                int id = rs.getInt("recipeId");
	                String name = rs.getString("name");
	                String description = rs.getString("description");
	                String ingredients = rs.getString("ingredients");
	                String instructions = rs.getString("instructions");
	                String imageUrl = rs.getString("imageUrl");
	                String category = rs.getString("Category");
	                recipe = new Recipe(id, name, description, ingredients, instructions, imageUrl, category);
	            }
	        }
	    } 

	    return recipe;
	}

	
	
	public static void main(String[] args) {
	    String searchQuery = "Rice"; 

	    try {
	        RecipeDAO dao = new RecipeDAO(); // Instantiate your DAO class

	        List<Recipe> recipes = dao.searchRecipesByIngredient(searchQuery);
 
	        if (recipes.isEmpty()) {
	            System.out.println("No recipes found with the given ingredient.");
	        } else {
	            System.out.println("Recipes containing '" + searchQuery + "':");
	            for (Recipe recipe : recipes) {
	                System.out.println("Recipe ID: " + recipe.getRecipeId());
	                System.out.println("Name: " + recipe.getName());
	                System.out.println("Description: " + recipe.getDescription());
	                System.out.println("Ingredients: " + recipe.getIngredients());
	                System.out.println("Instructions: " + recipe.getInstructions());
	                System.out.println("Category: " + recipe.getCategory());
	                System.out.println("User ID: " + recipe.getUserid());
	                System.out.println("Image URL: " + recipe.getImageUrl());
	                System.out.println(".........................................");
	            }
	        }

	    } catch (DAOException e) {
	        System.err.println("Error while searching for recipes: " + e.getMessage());
	    }
	}
	
	
	
}
