package com.fssa.recipe.service.recipefeature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


 class TestReadRecipeFeature {

	 static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");

            String selectQuery = "SELECT * FROM recipes";
            PreparedStatement statement = connection.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("RecipeID");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String ingredients = resultSet.getString("ingredients");
                String instructions = resultSet.getString("instructions");
                String imageUrl = resultSet.getString("imageUrl");

                System.out.println("Recipe ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Description: " + description);
                System.out.println("Ingredients: " + ingredients);
                System.out.println("Instructions: " + instructions);
                System.out.println("Image URL: " + imageUrl);
                System.out.println("11111111111111111111111111111111111111");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
