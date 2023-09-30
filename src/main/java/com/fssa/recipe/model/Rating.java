package com.fssa.recipe.model;

public class Rating {

	private int ratingId;
    private int recipeId;
    private int commentId;
    private int Userid;
    private double ratingValue;
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public double getRatingValue() {
		return ratingValue;
	}
	public void setRatingValue(double ratingValue) {
		this.ratingValue = ratingValue;
	}
	
}
