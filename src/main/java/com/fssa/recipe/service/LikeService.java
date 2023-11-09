package com.fssa.recipe.service;

import java.sql.SQLException;
import java.util.List;
import java.util.function.BooleanSupplier;

import com.fssa.recipe.dao.LikeDAO;
import com.fssa.recipe.model.Like;
import com.fssa.recipe.service.exception.ServiceException;
	

public class LikeService {

	// Method to add a like
    public boolean addLike(int userId, int recipeId) throws ServiceException {
        try {
            
            LikeDAO likesDAO = new LikeDAO(); 
            return likesDAO.addLike(userId, recipeId);
        } catch (SQLException | ClassNotFoundException e) {
            
            
            throw new ServiceException(e);
        }
    }
    
    
 // Method to get a list of recipes liked by a specific user
    public List<Integer> getLikedRecipes(int userId) throws ServiceException {
        try {
            LikeDAO likesDAO = new LikeDAO(); 

            return likesDAO.getLikedRecipesByUserId(userId);
        } catch (SQLException | ClassNotFoundException e) {
            
            
            throw new ServiceException(e);
        }
    }
    
    
    public boolean hasLiked(int userId, int recipeId) throws ServiceException {
        try {
            
            LikeDAO likesDAO = new LikeDAO(); 
            return likesDAO.hasLiked(userId, recipeId);
        } catch (SQLException | ClassNotFoundException e) {
            
           
            throw new ServiceException(e);
        }
    }
    
    
    public boolean disLike(int userId, int recipeId) throws ServiceException {
        try {
            
            LikeDAO likesDAO = new LikeDAO(); 
            return likesDAO.dislikeRecipe(userId, recipeId);
        } catch (SQLException | ClassNotFoundException e) {
            
           
            throw new ServiceException(e);
        }
    }


	
    
    
    

     
    
    
    
    
    
    
    
  
}
