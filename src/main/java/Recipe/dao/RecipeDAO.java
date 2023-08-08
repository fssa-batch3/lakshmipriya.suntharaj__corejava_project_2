package Recipe.dao;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Recipe.model.Recipe;

public class RecipeDAO {

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234567890");

}
    
    public boolean addRecipe(Recipe recipe) throws SQLException {
        Connection connection = getConnection();
        String query = "INSERT INTO recipes (name, description, ingredients, instructions, imageUrl) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pmt = connection.prepareStatement(query);
        pmt.setString(1, recipe.getName());
        pmt.setString(2, recipe.getDescription());
        pmt.setString(3, recipe.getIngredients());
        pmt.setString(4, recipe.getInstructions());
        pmt.setString(5, recipe.getImageurl());

        int rows = pmt.executeUpdate();

        pmt.close();
        connection.close();

        return rows == 1;
    }

   
    public Recipe getRecipeById(int recipeId) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM recipes WHERE id = ?";
        PreparedStatement pmt = connection.prepareStatement(query);
        pmt.setInt(1, recipeId);

        ResultSet rs = pmt.executeQuery();

        Recipe recipe = null;
        if (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String ingredients = rs.getString("ingredients");
            String instructions = rs.getString("instructions");
            String imageUrl = rs.getString("imageUrl");

            recipe = new Recipe(id, name, description, ingredients, instructions, imageUrl);
        }

        rs.close();
        pmt.close();
        connection.close();

        return recipe;
    }

    // Update recipe in DB
    public boolean updateRecipe(Recipe recipe) throws SQLException {
        Connection connection = getConnection();
        String query = "UPDATE recipes SET name = ?, description = ?, ingredients = ?, instructions = ?, imageUrl = ? WHERE id = ?";
        PreparedStatement pmt = connection.prepareStatement(query);
        pmt.setString(1, recipe.getName());
        pmt.setString(2, recipe.getDescription());
        pmt.setString(3, recipe.getIngredients());
        pmt.setString(4, recipe.getInstructions());
        pmt.setString(5, recipe.getImageurl());
        pmt.setInt(6, recipe.getId());

        int rows = pmt.executeUpdate();

        pmt.close();
        connection.close();

        return rows == 1;
    }

    // Delete recipe from DB
    public boolean deleteRecipe(int recipeId) throws SQLException {
        Connection connection = getConnection();
        String query = "DELETE FROM recipes WHERE id = ?";
        PreparedStatement pmt = connection.prepareStatement(query);
        pmt.setInt(1, recipeId);

        int rows = pmt.executeUpdate();

        pmt.close();
        connection.close();

        return rows == 1;
    }



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
}