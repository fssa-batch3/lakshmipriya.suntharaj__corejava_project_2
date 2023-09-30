package com.fssa.recipe.service;

import java.sql.SQLException;

import com.fssa.recipe.dao.RatingDAO;

import com.fssa.recipe.service.exception.ServiceException;

public class RatingsService {

	 public boolean addRatings(int recipeId, int commentId, int userId, double ratingValue) throws ServiceException {
	        try {
	        	
	        	RatingDAO ratingDAO = new RatingDAO();
	            return ratingDAO.addRating(recipeId, commentId, userId, ratingValue);

	        }  catch ( ClassNotFoundException | SQLException e) {
	        	e.printStackTrace();
	            throw new ServiceException("Failed to add Raings tocomment.");
	            
	        }
	    }
	
}
