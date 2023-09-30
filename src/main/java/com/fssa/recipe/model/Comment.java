package com.fssa.recipe.model;

import java.sql.Timestamp;

public class Comment {
	
	
	private int Userid;
	private int comment_id;
	private String comment;
    private int recipeId;
    private Timestamp createdTime;
    private String username;
    private String isDeleted;
	private double ratings;
	
    public double getRatings() {
		return ratings;
	}


	public void setRatings(double ratings) {
		this.ratings = ratings;
	}


	public Comment(int userid,int recipeId,  String comment, double ratings) {
		super();
		Userid = userid;
		this.comment = comment;
		this.recipeId = recipeId;
		this.ratings = ratings;
	}


	public String getIsDeleted() {
		return isDeleted;
	}


	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}


	public int getComment_id() {
		return comment_id;
	}


	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	
    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


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
