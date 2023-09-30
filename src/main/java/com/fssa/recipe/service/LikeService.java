package com.fssa.recipe.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.recipe.dao.LikeDAO;
import com.fssa.recipe.service.exception.ServiceException;
	

public class LikeService {

	// Method to add a like
    public boolean addLike(int userId, int recipeId) throws ServiceException {
        try {
            
            LikeDAO likesDAO = new LikeDAO(); 
            return likesDAO.addLike(userId, recipeId);
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }
    
    
 // Method to get a list of recipes liked by a specific user
    public List<Integer> getLikedRecipes(int userId) throws ServiceException {
        try {
            LikeDAO likesDAO = new LikeDAO(); 

            return likesDAO.getLikedRecipesByUserId(userId);
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }
    
    
    public boolean hasLiked(int userId, int recipeId) throws ServiceException {
        try {
            
            LikeDAO likesDAO = new LikeDAO(); 
            return likesDAO.hasLiked(userId, recipeId);
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }
    
    
    public boolean disLike(int userId, int recipeId) throws ServiceException {
        try {
            
            LikeDAO likesDAO = new LikeDAO(); 
            return likesDAO.dislikeRecipe(userId, recipeId);
        } catch (SQLException | ClassNotFoundException e) {
            
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }
    
    
    
//    
//    class Main {
//        public static void main(String[] args) {
//            LikeService likeService = new LikeService();
//
//            // Example usage: Adding a like
//            int userId = 13; // Replace with the actual user ID
//            int recipeId = 33; // Replace with the actual recipe ID
//
//            boolean likeAdded = likeService.addLike(userId, recipeId);
//
//            if (likeAdded) {
//                System.out.println("Like added successfully.");
//            } else {
//                System.out.println("Failed to add like.");
//            }
//
//            // You can add more operations here, such as removing likes or fetching likes.
//        }
//    }
//   
    
    
    
    
    //list like main method 
    
    
    
    
  
}
