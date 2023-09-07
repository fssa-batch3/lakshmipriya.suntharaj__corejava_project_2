package com.fssa.recipe.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.fssa.recipe.model.Recipe;
import com.fssa.recipe.util.Utilities;

public class RecipeDAO {

	
	
	
	
//add recipe to the database

	public boolean addRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {
		int rows = 0;
		String query = "INSERT INTO recipes (name, description, ingredients, instructions, imageUrl, Category) VALUES ( ?, ?, ?, ?, ? ,?)";
		try (Connection connection = Utilities.getConnection(); 

				PreparedStatement pmt = connection.prepareStatement(query))

		{

			pmt.setString(1, recipe.getName());
			pmt.setString(2, recipe.getDescription());
			pmt.setString(3, recipe.getIngredients());
			pmt.setString(4, recipe.getInstructions());
			pmt.setString(5, recipe.getImageUrl());
			pmt.setString(6, recipe.getCategory());

			rows = pmt.executeUpdate();
		}

		return rows == 1;
	}

// list recipes 
	public List<Recipe> getAllRecipes() throws SQLException, ClassNotFoundException {
		List<Recipe> recipes = new ArrayList<>();

		String query = "SELECT * FROM recipes WHERE isDeleted = 0 ";
		try (Connection connection = Utilities.getConnection(); 
				PreparedStatement pmt = connection.prepareStatement(query);
				ResultSet rs = pmt.executeQuery()) {

			while (rs.next()) {

				String name = rs.getString("name");
				String description = rs.getString("description");
				String ingredients = rs.getString("ingredients");
				String instructions = rs.getString("instructions");
				String imageUrl = rs.getString("imageUrl");
				String catagory = rs.getString("Category");
				Recipe recipe = new Recipe(name, description, ingredients, instructions, imageUrl, catagory);
				recipes.add(recipe);
			}
		}

		return recipes;
	}

	// Update recipe in DB
	public boolean updateRecipe(Recipe recipe) throws SQLException, ClassNotFoundException {
		String query = "UPDATE recipes SET name = ?, description = ?, ingredients = ?, instructions = ?, "
				+ "imageUrl = ? ,"+ " Category = ? WHERE RecipeID = ?";
		try (Connection connection = Utilities.getConnection(); 

				PreparedStatement pmt = connection.prepareStatement(query);) {
			pmt.setString(1, recipe.getName());
			pmt.setString(2, recipe.getDescription());
			pmt.setString(3, recipe.getIngredients());
			pmt.setString(4, recipe.getInstructions());
			pmt.setString(5, recipe.getImageUrl());
			pmt.setString(6, recipe.getCategory());
			pmt.setInt(7,recipe.getRecipeId());
			int rows = pmt.executeUpdate();

			return rows == 1;
		}

	}

	// Delete recipe from DB
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

}
