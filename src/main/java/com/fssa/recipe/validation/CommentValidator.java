package com.fssa.recipe.validation;

import com.fssa.recipe.model.Comment;

import com.fssa.recipe.validation.exception.InvalidCommentException;

public class CommentValidator {
    public static boolean validateComment(Comment comment) throws InvalidCommentException {
        validateUserId(comment.getUserid());
        validateCommentText(comment.getComment());
       
        
        return true;
    }

    public static boolean validateUserId(int userId) throws InvalidCommentException {
       
        if (userId < 1) {
            throw new InvalidCommentException("Invalid User ID");
        }
        return true;
    }

    public static boolean validateCommentText(String commentText) throws InvalidCommentException {
        if (commentText == null || commentText.trim().isEmpty()) {
            throw new InvalidCommentException("Invalid comment text");
        }
        return true;
    }

    

   
}

