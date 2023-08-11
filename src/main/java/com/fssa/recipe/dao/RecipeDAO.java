package com.fssa.recipe.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fssa.recipe.model.Recipe;

public class RecipeDAO {

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");

	}

	public boolean addRecipe(Recipe recipe) throws SQLException {
	    int rows = 0;
	    String query = "INSERT INTO recipes (RecipeID, name, description, ingredients, instructions, imageUrl) VALUES (?, ?, ?, ?, ?, ?)";
	    try (Connection connection = getConnection();
	       
	         PreparedStatement pmt = connection.prepareStatement(query))
	    
	    {
	            pmt.setInt(1, recipe.getRecipeId());
	            pmt.setString(2, recipe.getName());
	            pmt.setString(3, recipe.getDescription());
	            pmt.setString(4, recipe.getIngredients());
	            pmt.setString(5, recipe.getInstructions());
	            pmt.setString(6, recipe.getImageUrl());

	            rows = pmt.executeUpdate();
	        }
	
	    catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rows == 1;
	}

// list recipes 
	public List<Recipe> getAllRecipes() throws SQLException {
		List<Recipe> recipes = new ArrayList<>();

		try (Connection connection = getConnection();
				PreparedStatement pmt = connection.prepareStatement("SELECT * FROM recipes");
				ResultSet rs = pmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String ingredients = rs.getString("ingredients");
				String instructions = rs.getString("instructions");
				String imageUrl = rs.getString("imageUrl");

				Recipe recipe = new Recipe(id, name, description, ingredients, instructions, imageUrl);
				recipes.add(recipe);
			}
		}

		return recipes;
	}

	// Update recipe in DB
	public boolean updateRecipe(Recipe recipe) throws SQLException {
		String query = "UPDATE recipes SET name = ?, description = ?, ingredients = ?, instructions = ?, imageUrl = ? WHERE RecipeID = ?";
		try (Connection connection = getConnection();

				PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setString(1, recipe.getName());
			pmt.setString(2, recipe.getDescription());
			pmt.setString(3, recipe.getIngredients());
			pmt.setString(4, recipe.getInstructions());
			pmt.setString(5, recipe.getImageUrl());
			pmt.setInt(6, recipe.getRecipeId());

			int	rows = pmt.executeUpdate();
			pmt.close();
			connection.close();
			
			return rows == 1;
		} 

		
	}

	// Delete recipe from DB
	public boolean deleteRecipe(int recipeId) throws SQLException {
		
		String query = "DELETE FROM recipes WHERE id = ?";
		try(
		Connection connection = getConnection();
		PreparedStatement pmt = connection.prepareStatement(query)){;
		pmt.setInt(1, recipeId);

		int rows = pmt.executeUpdate();

		pmt.close();
		connection.close();

		return rows == 1;
	}
	}
}
