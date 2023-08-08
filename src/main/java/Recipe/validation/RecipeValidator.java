package Recipe.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import Recipe.model.Recipe;
import Recipe.validation.exception.InValidRecipeException;
public class RecipeValidator {

    public static boolean validateRecipe(Recipe recipe) throws InValidRecipeException {
        if (recipe != null && validateName(recipe.getName()) && validateDescription(recipe.getDescription())
                && validateIngredients(recipe.getIngredients()) && validateInstructions(recipe.getInstructions())
                && validateImageUrl(recipe.getImageUrl())) {
            return true;
        } else {
            throw new InValidRecipeException("Recipe details not valid");
        }
    }

    public static boolean validateName(String name) {
        boolean match = false;
        if (name == null)
            return false;
       

        return match;
    }

    public static boolean validateDescription(String description) {
        boolean match = false;
        if (description == null)
            return false;
        
        return match;
    }

    public static boolean validateIngredients(String ingredients) {
        boolean match = false;
        if (ingredients == null)
            return false;
        
        return match;
    }

    public static boolean validateInstructions(String instructions) {
        boolean match = false;
        if (instructions == null)
            return false;
       

        return match;
    }

    public static boolean validateImageUrl(String imageUrl) {
        boolean isMatch = false;
        if (imageUrl == null)
            return false;
       

        return isMatch;
    }
}
