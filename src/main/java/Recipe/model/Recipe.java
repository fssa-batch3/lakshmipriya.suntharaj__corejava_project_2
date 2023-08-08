package Recipe.model;

public class Recipe {

	private int id;
    private String name;
    private String description;
    private String ingredients;
    public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	private String instructions;
    private String imageUrl;

	
	
	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getImageurl() {
		return imageUrl;
	}
	public void setImageurl(String imageurl) {
		this.imageUrl = imageurl;
	}
	
	
	public String getCategory() {
		return getCategory();
	}
	
	@Override
	public String toString() {
		return "Recipe [recipeID=" + id+ ", recipeName=" + ", imageurl=" + imageUrl
				+ ", ingredients=" + ingredients + ", steps="  + ", category="  + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Recipe(int id, String name, String description, String ingredients, String instructions, String imageUrl) {
        this.id = id;
        this.setName(name);
        this.setDescription(description);
        this.ingredients = ingredients;
        this.setInstructions(instructions);
        this.imageUrl = imageUrl;
    }
	public Recipe(String string, String string2, String string3, String string4, String string5) {
		// TODO Auto-generated constructor stub
		this.setName(name);
        this.setDescription(description);
        this.ingredients = ingredients;
        this.setInstructions(instructions);
        this.imageUrl = imageUrl;
	}

	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		// TODO Auto-generated method stub
		return null;
	}
}
