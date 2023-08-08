package Recipe.validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestValidateName {

    @Test
    public void testValidName() {
        String validName = "LakshmiPriya";
        assertTrue(UserValidator.validateName(validName));
    }

    @Test
    public void testInvalidNameTooShort() {
        String invalidName = "Ak"; // Name must be at least 3 characters long
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    public void testInvalidNameTooLong() {
        String invalidName = "HIIIGuYYYYYssEPPDiIRUKINgaRATHIMALASAPTINGALA"; // Name cannot be longer than 29 characters
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    public void testInvalidNameContainsSpecialCharacters() {
        String invalidName = "User@name"; // Name can only contain letters, digits, and underscore
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    public void testInvalidNameStartsWithDigit() {
        String invalidName = "22user"; // Name cannot start with a digit
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    public void testInvalidNameNullInput() {
        String invalidName = null;
        assertFalse(UserValidator.validateName(invalidName));
    }

    @Test
    public void testInvalidNameEmptyInput() {
        String invalidName = "";
        assertFalse(UserValidator.validateName(invalidName));
    }
}
