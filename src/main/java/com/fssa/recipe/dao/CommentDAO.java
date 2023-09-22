package com.fssa.recipe.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.CommentService;
import com.fssa.recipe.service.exception.ServiceException;
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
	
	
	
	public List<Comment> getCommentsForRecipe(int recipeId) throws DAOException {
	    List<Comment> comments = new ArrayList<>();

	    String query = "SELECT c.Userid, c.comment_text, c.created_at, u.username " +
	                   "FROM comment c " +
	                   "INNER JOIN user u ON c.Userid = u.id " +
	                   "WHERE c.recipeId = ?";

	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, recipeId);

	        try (ResultSet rs = pmt.executeQuery()) {
	            while (rs.next()) {
	                Comment comment = new Comment();
	                comment.setUserid(rs.getInt("Userid"));
	                comment.setComment(rs.getString("comment_text"));
	                comment.setCreatedTime(rs.getTimestamp("created_at"));
	                comment.setRecipeId(recipeId);
	                comment.setUsername(rs.getString("username")); 

	                comments.add(comment);
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        throw new DAOException(e);
	    }

	    return comments;
	}
	
	
	public List<Comment> getCommentsForRecipeId(int recipeId) throws DAOException {
	    List<Comment> comments = new ArrayList<>();

	    String query = "SELECT Userid, comment_text, created_at FROM comment WHERE recipeId = ?";
	    
	    try (Connection connection = Utilities.getConnection();
	         PreparedStatement pmt = connection.prepareStatement(query)) {
	        pmt.setInt(1, recipeId); // Set the recipeId as a parameter

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

	    String query = "SELECT Userid, comment_text, created_at FROM comment WHERE recipeId = ? ORDER BY created_at DESC";
	    
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

	
	
}
