package com.fssa.recipe.service;



import com.fssa.recipe.dao.CommentDAO;
import com.fssa.recipe.dao.exception.DAOException;
import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.exception.ServiceException;
import com.fssa.recipe.validation.CommentValidator;
import com.fssa.recipe.validation.exception.InvalidCommentException;

public class CommentService {

	
	
	
    public boolean createComment(Comment comment) throws ServiceException {
        try {
        	CommentValidator.validateComment(comment);
        	CommentDAO commentDAO = new CommentDAO();
            return commentDAO.createComment(comment);

        }  catch ( DAOException | InvalidCommentException e) {
        	e.printStackTrace();
            throw new ServiceException("Failed to create comment.");
            
        }
    }
    
    
    
}