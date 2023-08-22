package com.fssa.recipe.model;

public class Recipe {

	private int RecipeId;
    private String name;
    private String description;
    private String ingredients;
    private String instructions;
    private String imageUrl;
   private String Category;
    private boolean isDeleted;

	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getRecipeId() {
		return RecipeId;
	}
	public void setRecipeId(int recipeId) {
		RecipeId = recipeId;
	}
	public Recipe(int recipeId, String name, String description, String ingredients, String instructions,
			String imageUrl, String category, boolean isDeleted) {
		super();
		RecipeId = recipeId;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		Category = Category;
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
//	public Recipe(int recipeId, String name, String description, String ingredients, String instructions,
//			String imageUrl) {
//		super();
//		RecipeId = recipeId;
//		this.name = name;
//		this.description = description;
//		this.ingredients = ingredients;
//		this.instructions = instructions;
//		this.imageUrl = imageUrl;
//		
//	}
//	
	public Recipe(int recipeId, String name, String description, String ingredients, String instructions,
			String imageUrl, String Category) {
		super();
		RecipeId = recipeId;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		Category = Category;
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
			String category) {
		super();
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
		Category = category;
	}
	@Override
	public String toString() {
		return "Recipe [RecipeId=" + RecipeId + ", name=" + name + ", description=" + description + ", ingredients="
				+ ingredients + ", instructions=" + instructions + ", imageUrl=" + imageUrl 
				+ ", isDeleted=" + isDeleted + "]";
	}
	public Recipe(int recipeId, String name, String description, String ingredients, String instructions,
			String imageUrl) {
		super();
		RecipeId = recipeId;
		this.name = name;
		this.description = description;
		this.ingredients = ingredients;
		this.instructions = instructions;
		this.imageUrl = imageUrl;
	}
	

    
}