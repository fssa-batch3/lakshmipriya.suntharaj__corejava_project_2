package com.fssa.recipe.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.model.Comment;
import com.fssa.recipe.service.exception.ServiceException;

public class TestCommentFeature2 {

	@Test
	void testCreateCommentSuccess() {
	    CommentService commentService = new CommentService();
	    Comment comment = new Comment(36, 24,  "This is a valid comment."); 	
	    try {
	        assertTrue(commentService.createComment(comment));
	        System.out.println(comment);
	    } catch (ServiceException e) {
	        e.printStackTrace();
	        fail("Failed to create comment: " + e.getMessage());
	    }
	} 

	}
