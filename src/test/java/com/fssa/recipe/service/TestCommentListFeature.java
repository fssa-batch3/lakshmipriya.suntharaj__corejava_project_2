package com.fssa.recipe.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.exception.ServiceException;

public class TestCommentListFeature {

	
	@Test
    void testGetCommentsForRecipe() {
        CommentService commentService = new CommentService();
       
        try {
            List<Comment> comments = commentService.getCommentsForRecipe(26);

            assertNotNull(comments);
            assertTrue(comments.size() >= 0);

            for (Comment comment : comments) {
                assertNotNull(comment.getUserid());
                assertNotNull(comment.getComment());
                assertNotNull(comment.getCreatedTime());
                
            }
            System.out.println(comments);
        } catch (ServiceException e) {
            fail("Failed to retrieve comments for recipe: " + e.getMessage());
        }
    }
}

