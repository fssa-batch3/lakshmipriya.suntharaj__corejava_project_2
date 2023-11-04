package com.fssa.recipe.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.exception.ServiceException;
 class TestCommentListFeature {

	
	@Test
    void testGetCommentsForRecipe() {
        CommentService commentService = new CommentService();
       
        try {
            List<Comment> comments = commentService.getCommentsForRecipeId(26);

            assertNotNull(comments);
            assertTrue(comments.size() >= 0);

            
            System.out.println(comments);
        } catch (ServiceException e) {
            fail("Failed to retrieve comments for recipe: " + e.getMessage());
        }
    }
}

