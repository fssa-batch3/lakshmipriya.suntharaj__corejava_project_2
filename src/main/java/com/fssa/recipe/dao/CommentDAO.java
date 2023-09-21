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
	        String query = "INSERT INTO comment (Userid, recipeId, comment_text) VALUES (?, ?, ?)";

	        try (Connection connection = Utilities.getConnection();
	             PreparedStatement pmt = connection.prepareStatement(query)) {
	            pmt.setInt(1, comment.getUserid());
	            pmt.setInt(2, comment.getRecipeId());
	            pmt.setString(3, comment.getComment());
	            
	            rows = pmt.executeUpdate();

	            return rows == 1;
	        } catch (ClassNotFoundException | SQLException e) {
	            throw new DAOException(e);
	        }
	    }
	
	
	public List<Comment> getCommentsForRecipe(int recipeId) throws DAOException {
        List<Comment> comments = new ArrayList<>();

        String query = "SELECT Userid, comment, createdTime FROM comments WHERE recipeId = ?";
        
        try (Connection connection = Utilities.getConnection();
             PreparedStatement pmt = connection.prepareStatement(query)) {
            pmt.setInt(1, recipeId);
            
            try (ResultSet rs = pmt.executeQuery()) {
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setUserid(rs.getInt("Userid"));
                    comment.setComment(rs.getString("comment"));
                    comment.setCreatedTime(rs.getTimestamp("createdTime"));
                   
                    comment.setRecipeId(recipeId);
                    
                    comments.add(comment);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException(e);
        }

        return comments;
    }
	
	
	
	
}
