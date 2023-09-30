package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fssa.recipe.util.Utilities;

public class RatingDAO {

	public boolean addRating(int recipeId, int commentId, int userId, double ratingValue) throws SQLException, ClassNotFoundException {
	    int rows = 0;
	    String sql = "INSERT INTO ratings (recipeId, commentId, userId, ratingValue) VALUES (?, ?, ?, ?)";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	        
	    	preparedStatement.setInt(1, recipeId);
            preparedStatement.setInt(2, commentId);
            preparedStatement.setInt(3, userId);
            preparedStatement.setDouble(4, ratingValue);

	        rows = preparedStatement.executeUpdate();
	    }
	    
	    return rows == 1;
}
}