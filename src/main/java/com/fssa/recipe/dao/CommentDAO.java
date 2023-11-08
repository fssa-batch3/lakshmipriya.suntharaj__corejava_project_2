package com.fssa.recipe.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.Comment;
import com.fssa.recipe.util.Utilities;

public class CommentDAO {

	public boolean createComment(Comment comment) throws DAOException {
	    int rows = 0;
	    String query = "INSERT INTO comment (Userid, recipeId, comment_text, ratings) VALUES (?, ?, ?, ?)";

	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, comment.getUserid());
	        pmt.setInt(2, comment.getRecipeId());
	        pmt.setString(3, comment.getComment());
	        pmt.setDouble(4, comment.getRatings()); 

	        rows = pmt.executeUpdate();

	        return rows == 1;
	    } catch (ClassNotFoundException | SQLException e) {
	        throw new DAOException(e);
	    }
	}
	 
	
	public List<Comment> getCommentsForRecipe() throws DAOException {
        List<Comment> comments = new ArrayList<>();

        String query = "SELECT Userid, comment_text, created_at FROM comment";
        
        try (Connection connection = Utilities.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
           
            
            try (ResultSet rs = pmt.executeQuery()) {
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setUserid(rs.getInt("Userid"));
                    comment.setComment(rs.getString("comment_text"));
                    comment.setCreatedTime(rs.getTimestamp("created_at"));
                    comments.add(comment);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e);
        }

        return comments;
    }
	
	
	
	
	
	
	
	
	
	public List<Comment> getCommentsForRecipeIdDesc(int recipeId) throws DAOException {
	    List<Comment> comments = new ArrayList<>();

	    String query = "SELECT comment.comment_id, recipes.recipeId, user.Userid, comment.comment_text, comment.ratings, comment.created_at "
	    	    + "FROM comment "
	    	    + "INNER JOIN recipes ON comment.recipeId = recipes.recipeId "
	    	    + "INNER JOIN user ON comment.UserId = user.UserId " 
	    	    + "WHERE recipes.recipeId = ? "
	    	    + "ORDER BY comment.created_at DESC";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, recipeId); 

	        try (ResultSet rs = pmt.executeQuery()) {
	            while (rs.next()) {
	                Comment comment = new Comment();
	                comment.setUserid(rs.getInt("Userid"));
	                comment.setComment(rs.getString("comment_text"));
	                comment.setCreatedTime(rs.getTimestamp("created_at"));
	                comments.add(comment);
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        throw new DAOException(e);
	    }

	    return comments;
	}


	public boolean deleteComment(int commendid) throws SQLException, ClassNotFoundException {
		String query = "UPDATE  recipes SET isDeleted = ? WHERE RecipeId = ?";
		try (Connection connection = Utilities.getConnection();
		    PreparedStatement pmt = connection.prepareStatement(query)) {
			pmt.setBoolean(1, true);
			pmt.setInt(2, commendid);
			int rows = pmt.executeUpdate();
			return rows == 1;
		}
	}
	
	
	
	public double getAverageRatingForRecipe(int recipeId) throws DAOException {
	    double averageRating = 0.0;
	    String query = "SELECT AVG(ratings) FROM comment WHERE recipeId = ?";

	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, recipeId);

	        try (ResultSet resultSet = pmt.executeQuery()) {
	            if (resultSet.next()) {
	                averageRating = resultSet.getDouble(1);
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        throw new DAOException(e);
	    }

	    return averageRating;
	}



	
}
