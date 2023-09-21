package com.fssa.recipe.model;

import java.sql.Timestamp;

public class Comment {
	
	
	private int Userid;
    private String comment;
    private int recipeId;
    private Timestamp createdTime;

    public Comment(int userid,  int recipeId, String comment) {
		super();
		Userid = userid;
		this.comment = comment;
		this.recipeId = recipeId;
		
	}


	public Comment() {
		
	}


	public int getUserid() {
        return Userid;
    }

    public void setUserid(int Userid) {
        this.Userid = Userid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }
}
