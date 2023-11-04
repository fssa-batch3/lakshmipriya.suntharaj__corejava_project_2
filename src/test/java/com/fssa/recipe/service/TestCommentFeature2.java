package com.fssa.recipe.service;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;
import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.exception.ServiceException;

class TestCommentFeature2 {

	@Test
	void testCreateCommentSuccess() {
	    CommentService commentService = new CommentService();
	    Comment comment = new Comment(36, 24,  "This is a valid comment."); 	
	    try {
	        assertTrue(commentService.createComment(comment));
	        
	    } catch (ServiceException e) {
	        
	        fail("Failed to create comment: " + e.getMessage());
	    }
	} 

	}
