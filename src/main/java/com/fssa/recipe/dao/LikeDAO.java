package com.fssa.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.recipe.util.Utilities;

public class LikeDAO {

	public boolean addLike(int userId, int recipeId) throws SQLException, ClassNotFoundException {
    int rows = 0;
    String query = "INSERT INTO likes (user_id, recipe_id) VALUES (?, ?)";
    
    try (Connection connection = Utilities.getConnection();
         PreparedStatement pmt = connection.prepareStatement(query)) {
        
        pmt.setInt(1, userId);
        pmt.setInt(2, recipeId);
        rows = pmt.executeUpdate();
    }
      
    return rows == 1;
}
	
	// Method to get liked recipes by user ID
    public List<Integer> getLikedRecipesByUserId(int userId) throws SQLException, ClassNotFoundException {
        List<Integer> likedRecipeIds = new ArrayList<>();

        String query = "SELECT recipe_id FROM likes WHERE user_id = ? AND isDeleted= 0 ";
        
        try (Connection connection = Utilities.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            
            pmt.setInt(1, userId);
            
            try (ResultSet rs = pmt.executeQuery()) {
                while (rs.next()) {
                    likedRecipeIds.add(rs.getInt("recipe_id"));
                }
            }
        }

        return likedRecipeIds;
    }


    public boolean hasLiked(int userId, int recipeId) throws SQLException, ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM likes WHERE user_id = ? AND recipe_id = ?";

        try (Connection connection = Utilities.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {

            pmt.setInt(1, userId);
            pmt.setInt(2, recipeId);

            try (ResultSet rs = pmt.executeQuery()) {
                if (rs.next()) {
                    int likeCount = rs.getInt(1);
                    return likeCount > 0;
                }
            }
        }

        return false;
    }
    
    public boolean dislikeRecipe(int userId, int recipeId) throws SQLException, ClassNotFoundException {
	    String query = "UPDATE likes SET isDeleted = ? WHERE user_id = ? AND recipe_id = ?";
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setBoolean(1, true);
	        pmt.setInt(2, userId);
	        pmt.setInt(3, recipeId);
	        int rows = pmt.executeUpdate();
	        return rows == 1;
	    }
	}
}
    
    
	

