/*
 * Final Project Submission
 * Ken Rodriguez
 * Dr. Sam Shamsuddin
 */

/**
 * Executes code for testing the Recipe_Box and Recipe classes.
 *
 * @author Ken Rodriguez
 * @version 1.0
 */

public class UnitTest {
    /**
     * The "entry" point of the program.
     * The main method in this case will instantiate three cases for testing: first, a test for editing recipes.
     * Second, a populated recipe box, and third, an "empty" recipe box to test outputs for empty recipe box cases.
     * To populate the Recipe_Box, two recipes are created using the Ingredient constructor w/ arguments and
     * the Recipe object's addNewIngredient method.
     *
     * @param args Commandline arguments passed to the program.
     */
    public static void main(String[] args) {
        // Initialize our recipeBox
        Recipe_Box testRecipeBox = new Recipe_Box();

        /// Create ingredients, populate our first recipe w/ mac & cheese
        Ingredient milk = new Ingredient("Milk", "cups", 5,
                103);
        Ingredient macaroni = new Ingredient("Macaroni", "lbs", 1,
                1685);
        Ingredient cheese = new Ingredient("Cheddar", "cups", 2,
                455);
        Recipe myFirstRecipe = new Recipe("Macaroni", 4);
        myFirstRecipe.addRecipeIngredient(milk);
        myFirstRecipe.addRecipeIngredient(macaroni);
        myFirstRecipe.addRecipeIngredient(cheese);
        testRecipeBox.addRecipe(myFirstRecipe);

        /// Create ingredients and initialize second recipe
        Ingredient flour = new Ingredient("Flour", "cups", 1.0,
                455);
        Ingredient yogurt = new Ingredient("Yogurt", "cups", 1.0,
                100);
        Recipe mySecondRecipe = new Recipe("Rolls", 8);
        mySecondRecipe.addRecipeIngredient(flour);
        mySecondRecipe.addRecipeIngredient(yogurt);
        testRecipeBox.addRecipe(mySecondRecipe);

        // Test if first recipe box has been properly populated
        System.out.println("Recipes contained in testRecipeBox: ");
        for (Recipe recipe : testRecipeBox.getListOfRecipes()){
            System.out.println(recipe.getRecipeName());
        }

        // Test recipe modification
        System.out.println("\n*** TEST RECIPE EDITING ***");
        mySecondRecipe.editRecipe();
        System.out.println("\n*** END RECIPE EDITING TEST ***");

        // Load recipe box's menu for user input.
        System.out.println("\n*** TEST POPULATED RECIPEBOX ***");
        System.out.println("Enter 6 to proceed to next recipeBox.\n");
        testRecipeBox.menu();
        System.out.println("*** END POPULATED RECIPEBOX TEST ***");

        // Test empty recipe box.
        System.out.println("\n*** TEST EMPTY RECIPEBOX ***");
        Recipe_Box emptyRecipeBox = new Recipe_Box();
        emptyRecipeBox.menu();
        System.out.println("*** END EMPTY RECIPEBOX TEST ***");
    }
}
