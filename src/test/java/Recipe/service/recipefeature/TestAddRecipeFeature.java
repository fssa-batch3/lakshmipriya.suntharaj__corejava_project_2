package Recipe.service.recipefeature;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import Recipe.model.Recipe;
import Recipe.service.RecipeService;
import Recipe.service.exception.ServiceException;

public class TestAddRecipeFeature {
    @Test
    public void testAddRecipeSuccess() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe( "Pasta Carbonara", "Delicious pasta dish with bacon and cream sauce.",
                "Pasta, Bacon, Eggs, Parmesan cheese, Cream, Garlic, Black pepper, Salt",
                "1. Cook pasta according to package instructions.\n2. In a pan, fry bacon until crispy.\n3. In a bowl, whisk eggs, grated parmesan, cream, minced garlic, black pepper, and a pinch of salt.\n4. Drain cooked pasta and add it to the pan with bacon, then turn off the heat.\n5. Pour the egg mixture over the pasta and toss until coated in the sauce.\n6. Serve immediately with extra parmesan on top.",
                "https://www.example.com/images/pasta-carbonara.jpg");
        
        try {
        	assertTrue(recipeService.addRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
         //fail();
        }
    }

    @Test
    public void testAddRecipeSuccess2() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe("Chocolate Chip Cookies", "Classic homemade chocolate chip cookies.",
                "Flour, Butter, Sugar, Brown sugar, Eggs, Vanilla extract, Baking soda, Salt, Chocolate chips",
                "1. Preheat oven to 375°F (190°C).\n2. In a mixing bowl, cream together butter, sugar, and brown sugar until smooth.\n3. Beat in eggs and vanilla extract.\n4. In a separate bowl, whisk together flour, baking soda, and salt.\n5. Gradually add dry ingredients to the wet ingredients and mix until just combined.\n6. Stir in chocolate chips.\n7. Drop spoonfuls of dough onto a baking sheet.\n8. Bake for 9-11 minutes, or until the edges are golden brown.\n9. Let cool on the baking sheet for a few minutes before transferring to a wire rack to cool completely.",
                "https://www.example.com/images/chocolate-chip-cookies.jpg");

        try {
            assertTrue(recipeService.addRecipe(recipe));
        } catch (ServiceException e) {
            e.printStackTrace();
            //fail();
        }
    }




	@Test
    public void testAddRecipeMissingName() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = new Recipe( "", "Invalid Recipe", "Ingredient1, Ingredient2", "Instructions",
                "https://www.example.com/images/invalid.jpg");

        try {
            assertFalse(recipeService.addRecipe(recipe));
            } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddRecipeNullInput() {
        RecipeService recipeService = new RecipeService();
        Recipe recipe = null;

        try {
            assertFalse(recipeService.addRecipe(recipe)); 
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}


