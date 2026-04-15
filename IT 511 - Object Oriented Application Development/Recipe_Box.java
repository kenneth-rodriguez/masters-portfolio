/*
 * Final Project Submission
 * Ken Rodriguez
 * Dr. Sam Shamsuddin
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a box of recipes with attributes for storing said list of recipes.
 * Includes methods to produce the stored list of recipes, replace that list of recipes,
 * add a new recipe to the recipe box, print the details of one recipe stored in this box,
 * print a list of all recipes stored in this box to console, edit an existing recipe, delete
 * an existing recipe, and provide a comprehensive menu to navigate these features.
 * Intended to function as a recipe box storing the user's Recipes.
 */
public class Recipe_Box {
	private ArrayList<Recipe> listOfRecipes = new ArrayList<Recipe>();

	/// Accessors and Mutators
	/**
	 * Get every Recipe stored in this Recipe Box.
	 *
	 * @return Array list listOfRecipes
	 */
	public ArrayList<Recipe> getListOfRecipes() {
		return listOfRecipes;
	}

	/**
	 * Replace this Recipe Box's list of recipes with another list of recipes.
	 *
	 * @param listOfRecipes new list of recipes
	 */
	public void setListOfRecipes(ArrayList<Recipe> listOfRecipes) {
		this.listOfRecipes = listOfRecipes;
	}

	/**
	 * Add a recipe to this Recipe Box.
	 *
	 * @param tmpRecipe recipe to add to this Recipe Box.
	 */
	public void addRecipe(Recipe tmpRecipe){
		this.listOfRecipes.add(tmpRecipe);
	}

	// CONSTRUCTORS
	/**
	 * Empty constructor to create a recipe box without arguments.
	 */
	Recipe_Box(){
		this.listOfRecipes = new ArrayList<>();
	}

	/**
	 * Create a new recipe box with a recipe simultaneously.
	 *
	 * @param newRecipe Recipe to be added during Recipe_Box construction
	 */
	Recipe_Box(ArrayList<Recipe> newRecipe){
		this.listOfRecipes = new ArrayList<>(newRecipe);
	}

	// Helper Methods
	/**
	 * For the selected recipe, print its details including its name, servings, every ingredient contained,
	 * and its total caloric content.
	 *
	 * @param selectedRecipe the intended recipe to print details
	 */
	public void printAllRecipeDetails(Recipe selectedRecipe){
		selectedRecipe.printRecipe();
	}

	/**
	 * Print all recipe names contained within this Recipe Box
	 */
	public void printAllRecipeNames(){
		int index = 0;
		// to get all recipes, enhanced for loop to print all recipe names in listOfRecipes.
		for (Recipe recipe : this.listOfRecipes){
			System.out.println((index + 1) + ": " + recipe.getRecipeName());
			index++;
		}
		if (this.listOfRecipes.isEmpty()){
			System.out.println("No recipes found in this recipe box.");
		}

		// Cleaner output
		System.out.println();
	}

	/**
	 * Print a specific recipe's details using the printRecipeDetails helper method
	 */
	public void getRecipeDetails() {
		Scanner detailScnr = new Scanner(System.in);

		// Check to see if the recipe name is actually in the recipeBox's listOfRecipes
		if (!this.listOfRecipes.isEmpty()) {
			System.out.println("Which recipe's details would you like to print?");
			printAllRecipeNames();
			System.out.println("Please enter the recipe's name:");

			// Check and compare recipe names stored in recipeName objects.
			String selectedRecipeName = detailScnr.next();

			boolean recipeFound = false;
			for (Recipe recipe : this.getListOfRecipes()) {
				if (recipe.getRecipeName().equalsIgnoreCase(selectedRecipeName)) {
					System.out.println();
					this.printAllRecipeDetails(recipe);
					recipeFound = true;
				}
			}
			// If recipe not found, inform user
			if (!recipeFound){
				System.out.println("Recipe \"" + selectedRecipeName + "\" not found.\n");
			}
		}
		// No recipes? let the user know.
		else {
			System.out.println("No recipes found in this recipe box.\n");
		}
	}

	/**
	 * Take console input to select a recipe contained within this Recipe Box.
	 * If a recipe is found, that recipe will provide an edit menu. If the recipe
	 * is not found, the user will be informed of that.
	 */
	/// Final Rubric: "edit an item that is already in the collection."
	public void editRecipe() {
		Scanner editScnr = new Scanner(System.in);

		if(listOfRecipes.isEmpty()){
			System.out.println("No recipes found in this Recipe Box.");
		}
		else {
			System.out.println("What recipe would you like to modify?");

			// Print a list of all recipes in recipe box
			for (Recipe recipe : this.getListOfRecipes()) {
				System.out.println(recipe.getRecipeName());
			}

			System.out.println("Please enter the recipe's name or enter \"exit\" to exit.");
			String nameCheck = editScnr.nextLine();

			/// Use recipe's editIngredients method to add or remove ingredients
			boolean quit = false;
			do {
				// If the user types "end" break loop.
				if (nameCheck.equalsIgnoreCase("exit")) {
					quit = true;
				}
				// If user types in a name or other string, check the array. if the string is found, execute recipe.editRecipe(); if not, just quit.
				else {
					boolean recipeFound = false;
					for (Recipe recipe : this.getListOfRecipes()) {
						if (recipe.getRecipeName().equalsIgnoreCase(nameCheck)) {
							recipe.editRecipe();
							recipeFound = true;
							quit = true;
							break;
						}
					}
					if (!recipeFound) {
						System.out.println("Recipe \"" + nameCheck + "\" not found.\n");
						quit = true;
					}
				}
			} while (!quit);
		}
	}

	/**
	 * Method to select and delete a recipe stored within this Recipe Box.
	 * User is prompted to type in a recipe's name; if that recipe is found
	 * in this Recipe Box,  it is deleted. If not, the user is informed of that.
	 */
	/// Final Rubric: "Program should allow the user to delete an item from the collection."
	public void deleteRecipe() {
		// Scanner to parse input
		Scanner delScnr = new Scanner(System.in);

		// Prompt user. If empty, don't.
		if (listOfRecipes.isEmpty()) {
			System.out.println("No recipes found in this recipe box.");
		}
		else {
			System.out.println("What recipe would you like to delete?");

			this.printAllRecipeNames();

			System.out.println("Please enter the recipe's name or input \"exit\" to exit.");
			String nameCheck = delScnr.nextLine();

			boolean quit = false;
			do {
				// If the user types "end" break loop. If not, check the array to see if the recipe *can* be deleted.
				if (nameCheck.equalsIgnoreCase("exit")) {
					quit = true;
				} else {
					boolean recipeFound = false;
					for (Recipe recipe : this.getListOfRecipes()) {
						if (recipe.getRecipeName().equalsIgnoreCase(nameCheck)) {
							this.getListOfRecipes().remove(recipe);
							System.out.println(nameCheck + " successfully deleted.\n");
							recipeFound = true;
							quit = true;
							break;
						}
					}
					if (!recipeFound) {
						System.out.println("Recipe " + nameCheck + " not found.\n");
						quit = true;
					}
				}
			} while (!quit);
		}
	}


	/**
	 * "Main" menu method to prompt user for inputs in this recipe box. A menu is printed with options.
	 * Users are given the opportunity to add a new recipe to the recipe box, print
	 * one recipe's details, print the names of every recipe stored, edit an existing
	 * recipe, delete an existing recipe, or quit the application.
	 */
	public void menu() {
		//SteppingStone6_RecipeBox myRecipeBox = new SteppingStone6_RecipeBox(); //Uncomment for main method
        Scanner menuScnr = new Scanner(System.in);

		// String to reuse for loops
		String menuOptions = ("""
                Main Menu
                1. Add New Recipe
                2. Print One Recipe's Details
                3. Print All Recipe Names
                4. Edit Recipe
                5. Delete Recipe
                6. Exit Recipe Box Application
                
                Please select a menu item:""");

		// Print menu w/ Add Recipe, Print Recipe, and Print All Recipe Details options.
		System.out.println(menuOptions);

        while (menuScnr.hasNextInt() || menuScnr.hasNextLine()) {
            int input = menuScnr.nextInt();

			// Add Recipe
			if (input == 1) {
				Recipe newRecipe = new Recipe();
				newRecipe.createNewRecipe();
				addRecipe(newRecipe);
            }
			else if (input == 2) {
				getRecipeDetails();
            }
			else if (input == 3) {
				printAllRecipeNames();
            }
			/// Rubric: Implement Edit Recipe Selection.
			else if (input == 4){
				editRecipe();
			}
			/// Rubric: Implement Delete Recipe Selection.
			else if (input == 5){
				deleteRecipe();
			}
			// Exit option for easier user input testing/"proper" exit condition
			else if (input == 6){
				System.out.println("Successfully Quit.\n");
				break;
			}
			else {
				System.out.println("Invalid selection.\n");
            }

			System.out.println(menuOptions);
		}
	}
}
