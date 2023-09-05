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
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");

	}
//add recipe to the database

	public boolean addRecipe(Recipe recipe) throws SQLException {
		int rows = 0;
		String query = "INSERT INTO recipes (name, description, ingredients, instructions, imageUrl, Category) VALUES ( ?, ?, ?, ?, ? ,?)";
		try (Connection connection = getConnection();

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
	public List<Recipe> getAllRecipes() throws SQLException {
		List<Recipe> recipes = new ArrayList<>();

		String query = "SELECT * FROM recipes WHERE isDeleted = 0 ";
		try (Connection connection = getConnection();
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
	public boolean updateRecipe(Recipe recipe) throws SQLException {
		String query = "UPDATE recipes SET name = ?, description = ?, ingredients = ?, instructions = ?, "
				+ "imageUrl = ? ,"+ " Category = ? WHERE RecipeID = ?";
		try (Connection connection = getConnection();

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
	public boolean deleteRecipe(int recipeId) throws SQLException {
		String query = "UPDATE  recipes SET isDeleted = ? WHERE RecipeId = ?";
		try (Connection connection = getConnection(); 
		    PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true); // Set isDeleted to true to mark the design as deleted
			pmt.setInt(2, recipeId);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}

}
