/*
 * Final Project Submission
 * Ken Rodriguez
 * Dr. Sam Shamsuddin
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Represents a recipe with a name, number of servings, total caloric value, and a list of all ingredients used to make
 * this recipe.
 * Includes methods to get (Accessors) and set (Mutators) each of these properties, with the intent of creating a
 * comprehensive recipe to be used with a Recipe_Box structure.
 *
 * @author Ken Rodriguez
 * @version 1.0
 */
public class Recipe {

    // Private instance variables
    private String recipeName;
    private int servings;
    private double totalRecipeCalories;
    ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();

    // ACCESSORS/getters
    /**
     * Get this recipe's name.
     *
     * @return this recipe's name.
     */
    public String getRecipeName(){
        return recipeName;
    }

    /**
     * Get this recipe's number of servings.
     *
     * @return number of servings
     */
    public int getServings() {
        return servings;
    }

    /**
     * Get this recipe's total number of calories.
     *
     * @return the total number of calories for this recipe
     */
    public double getTotalRecipeCalories(){
        return totalRecipeCalories;
    }

    /**
     * Get the list of ingredients contained by this recipe.
     *
     * @return a list of all ingredients stored in this recipe
     */
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    // MUTATORS/setters
    /**
     * Set the recipe's new name.
     *
     * @param newName the recipe's new name
     */
    public void setRecipeName(String newName){
        recipeName = newName;
    }

    /**
     * Set the number of servings for this recipe.
     *
     * @param newServings the recipe's new number of servings
     */
    public void setServings(int newServings){
        servings  = newServings;
    }

    /**
     * Set the total caloric amount for this recipe.
     *
     * @param newTotalCal the recipe's total caloric content
     */
    public void setTotalRecipeCalories(double newTotalCal){
        totalRecipeCalories = newTotalCal;
    }

    /**
     * Add a new ingredient to the recipe's ingredient list, then calculate and set this recipe's total caloric content.
     *
     * @param newIngredient the Ingredient to be added to the ingredient list
     */
    // Add ingredient, add to its caloric amount to total recipe calories
    public void addRecipeIngredient(Ingredient newIngredient){
        recipeIngredients.add(newIngredient);
        this.setTotalRecipeCalories(this.getTotalRecipeCalories() + newIngredient.getTotalCalories());
    }

    /**
     * Create a new Recipe object with default "blank" values.
     */
    // Empty constructor
    public Recipe() {
        this.recipeName = "";
        this.servings = 0;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
    }

    /**
     * Create a new Recipe object with specified properties.
     *
     * @param recipeName the name of the recipe
     * @param servings the recipe's number of servings
     */
    // Constructor w/ datatypes
    public Recipe(String recipeName, int servings)
    {
        this.recipeName = recipeName;
        this.servings = servings;
        this.recipeIngredients = new ArrayList<>();
        this.totalRecipeCalories = 0;
    }

    /**
     * Create a new Ingredient object with user prompts, then add it to the Recipe's ingredient list.
     */
    // Helper method to create new ingredient w/o repeating code *too* much
    public void createNewIngredient(){
        boolean addMoreIngredients = true;

        Scanner scnr = new Scanner(System.in);

        do {
            // Create new "empty" ingredient to collect data
            Ingredient newIngredient = new Ingredient();

            System.out.println("Please enter the ingredient name or type end if you are finished entering ingredients: ");
            String ingredientName = scnr.next();
            if (ingredientName.equalsIgnoreCase("end") || ingredientName.equalsIgnoreCase("exit")) {
                addMoreIngredients = false;
            }
            else {
                newIngredient.setNameOfIngredient(ingredientName);

                System.out.println("Please enter the ingredient's unit of measurement: ");
                newIngredient.setUnitMeasurement(scnr.next());

                System.out.println("Please enter the number of " + newIngredient.getUnitMeasurement()
                        + " for this recipe: ");
                newIngredient.setIngredientAmount(scnr.nextDouble());

                System.out.println("Please enter the number of calories per one " +
                        newIngredient.getUnitMeasurement() + ": ");
                newIngredient.setTotalCalories(scnr.nextInt());

                // Calculate new total recipe calories.
                this.setTotalRecipeCalories(this.getTotalRecipeCalories() +
                        (newIngredient.getTotalCalories() * newIngredient.getIngredientAmount()));

                recipeIngredients.add(newIngredient);
            }
        } while (addMoreIngredients);
    }

    /**
     * Remove an existing Ingredient from this Recipe.
     */
    // Helper method to delete ingredient in array
    public void deleteIngredient(){
        Scanner scnr = new Scanner(System.in);

        System.out.println("Recipe: " + this.getRecipeName() + "\n----------");
        for(Ingredient ingredient : recipeIngredients){
            System.out.println(ingredient.getNameOfIngredient());
        }
        System.out.println("Please enter the name of the ingredient you would like to remove, or type \"exit\" to quit.");

        boolean quit = false;
        String nameCheck = scnr.nextLine();

        // If the user types "end" break loop. If not, check the array to see if the recipe *can* be deleted.
        if (nameCheck.equalsIgnoreCase("exit")) {
            quit = true;
        } else {
            boolean ingredientFound = false;
            for (Ingredient ingredient : this.getRecipeIngredients()) {
                if (ingredient.getNameOfIngredient().equalsIgnoreCase(nameCheck)) {
                    this.getRecipeIngredients().remove(ingredient);
                    System.out.println(nameCheck + " successfully deleted.\n");
                    ingredientFound = true;
                    quit = true;
                    break;
                }
            }
            if (!ingredientFound) {
                System.out.println("Recipe " + nameCheck + " not found.\n");
                quit = true;
            }
        }
    }

    /**
     * Print this recipe's details, including its name, servings, every ingredient, and total caloric content.
     */
    public void printRecipe() {
        // Count the calories for a single serving
        double singleServingCalories = (totalRecipeCalories / servings);

        System.out.println("Recipe: " + this.getRecipeName());
        System.out.println("Serves: " + this.getServings());
        System.out.println("Ingredients\n----------");

        // Enhanced "for" loop to print recipeIngredients array contents
        for (Ingredient recipeIngredient : recipeIngredients) {
            System.out.println(recipeIngredient.getNameOfIngredient());
        }

        // Print final calorie count, then add space to keep things readable.
        System.out.println("Each serving has " + singleServingCalories + " Calories.");
        System.out.println();
    }

    /**
     * Provides a menu to offer options for adding a new ingredient to this recipe, delete an
     * existing ingredient, print this recipe's details, or return to the main menu.
     * Final Rubric: "edit an item that is already in the collection."
     * Final Rubric: "your program should allow the user to delete an item from the collection."
     */
    public void editRecipe(){
        Scanner editScnr = new Scanner(System.in);

        boolean quit = false;
        // Print recipe name so user knows what recipe they're modifying
        String editMenuOptions = """
                
                Edit Recipe Menu:\s""" +
                this.getRecipeName() + """
                
                1. Add New Ingredient
                2. Remove Existing Ingredient
                3. Print This Recipe's Details
                4. Exit""";

        System.out.println(editMenuOptions);

        while (editScnr.hasNextInt() || editScnr.hasNextLine()) {
            int input = editScnr.nextInt();

            // check user input w/ switch
            switch (input) {
                case 1:
                    createNewIngredient();
                    break;
                case 2:
                    deleteIngredient();
                    break;
                case 3:
                    printRecipe();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Please input a valid selection.");
            }

            if (quit){
                break;
            }

            System.out.println(editMenuOptions);
        }

    }

    /**
     * Create new recipe step by step through the console.
     */
    public void createNewRecipe() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please enter the recipe name: ");
        this.setRecipeName(scnr.nextLine());

        System.out.println("Please enter the number of servings: ");
        //correct data type & Scanner assignment method for servings variable
        this.setServings(scnr.nextInt());

        createNewIngredient();
    }
}

