package com.fssa.recipe.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.recipe.validation.exception.InValidRecipeException;

class TestRecipeImageUrl {
   
	 @Test
	 void testValidImageUrlUsingPng() throws InValidRecipeException {
	     assertTrue(RecipeValidator.validateImageUrl("http://example.com/image.png"));
	    
	 }


	 @Test
	  void testValidImageUrlUsingJpg() throws InValidRecipeException {
	     assertTrue(RecipeValidator.validateImageUrl("https://example.com/image.jpg"));
	 }



	 @Test
	 void testInvalidImageUrlwithOutPngOrJpg() {
	     assertThrows(InValidRecipeException.class, () -> RecipeValidator.validateImageUrl("https://example.com/image"));
	 }

	 @Test
	 void testInvalidImageUrlWithPdf() {
	     assertThrows(InValidRecipeException.class, () -> RecipeValidator.validateImageUrl("https://example.com/document.pdf"));
	 }


	 @Test
	  void testInvalidImageUrlJpeg() {
	     assertThrows(InValidRecipeException.class, () -> RecipeValidator.validateImageUrl("https://example.com/image.jpeg"));
	 }


	
}
