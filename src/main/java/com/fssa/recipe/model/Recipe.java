package com.fssa.recipe.model;

public class Recipe {

	private String name;
    private String description;
    private String ingredients;
    private String instructions;
    private String imageUrl;
    private String category;
    private boolean isDeleted;
    private int Userid;
    private int recipeId;
    private int Liked;
    
	


	public int getLiked() {
		return Liked;
	}


	public void setLiked(int liked) {
		Liked = liked;
	}


	public Recipe(int userid, int recipeId) {
		super();
		Userid = userid;
		this.recipeId = recipeId;
		
	}


	public int getUserid() {
		return Userid;
	}


	public void setUserid(int userid) {
		Userid = userid;
	}


	public Recipe(int recipeId,String name, String description, String ingredients, String instructions, String imageUrl,
			String category ) {
		super();
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		this.category = category;
		this.recipeId = recipeId;
	}

// update recipe 
	

	
	
	
	public Recipe(int recipeId, String name, String description, String ingredients, String instructions,
			String imageUrl, String category, boolean isDeleted) {
		super();
		this.recipeId = recipeId;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		this.category = category;
		this.isDeleted = isDeleted;
	}
	
    
    


	public int getRecipeId() {
		return recipeId;
	}
	
    
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public Recipe( String name, String description, String ingredients, String instructions,
			String imageUrl, String category, boolean isDeleted) {
		super();
		
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		this.category = category;
		this.isDeleted = isDeleted;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getName() {
		return name; 
	}
	public void setName(String name) { 
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	
	public Recipe(String name, String description, String ingredients, String instructions, String imageUrl
		) {
		super();
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		
	}
	public Recipe(String name, String description, String ingredients, String instructions, String imageUrl,
			String category,int Userid) {
		super();
		
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		this.category = category;
		this.Userid = Userid;
	}
	


	public Recipe() {
		
	}

	
	

	public Recipe(String name, String description, String ingredients, String instructions, String imageUrl, String category) {
	    // Initialize the fields with the provided arguments
	    this.name = name;
	    this.description = description;
	    this.ingredients = ingredients;
	    this.instructions = instructions;
	    this.imageUrl = imageUrl;
	    this.category = category;
	}

	@Override
	public String toString() {
		return "Recipe [RecipeId=" + recipeId + ", name=" + name + ", description=" + description + ", ingredients="
				+ ingredients + ", instructions=" + instructions + ", imageUrl=" + imageUrl 
				+ ", isDeleted=" + isDeleted + "]";
	}


	
	
}