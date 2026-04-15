/*
 * Final Project Submission
 * Ken Rodriguez
 * Dr. Sam Shamsuddin
 */


import java.util.Scanner;

/**
 * Represents an ingredient with a name, unit of measurement, amount, and the number of calories per cup of that ingredient.
 * Includes methods to get (Accessors) and set (Mutators) these properties with the intention of allowing ingredients
 * to be used in Recipe structures.
 *
 * @author Ken Rodriguez
 * @version 0.0
 */
public class Ingredient {

    // Initialize Ingredient properties
    private String nameOfIngredient = "";
    private String unitMeasurement = "";
    private double ingredientAmount = 0.0;
    private int numberCaloriesPerCup = 0;
    private double totalCalories = 0.0;

    // Accessors

    /** Retrieve the name of an ingredient
     *
     * @return The ingredient's name
     */
    public String getNameOfIngredient(){
        return nameOfIngredient;
    }

    /**
     * Get the ingredient's specified unit of measurement.
     *
     * @return this ingredient's unit of measurement
     */
    public String getUnitMeasurement(){
        return unitMeasurement;
    }

    /**
     * Get the amount of the ingredient needed in the ingredient's unit of measurement.
     *
     * @return the amount of the ingredient needed in the ingredient's unit of measurement
     */
    public double getIngredientAmount() {
        return ingredientAmount;
    }

    /**
     * Get the number of calories per unit of measurement of this ingredient.
     *
     * @return the number of calories in the specified unit of measurement for this ingredient
     */
    public int getNumberCaloriesPerCup() {
        return numberCaloriesPerCup;
    }

    /**
     * Get the total number of calories for this ingredient.
     *
     * @return the total number of calories for the allotted amount of this ingredient
     */
    public double getTotalCalories() {
        return totalCalories;
    }

    // Mutators

    /**
     * Set the ingredient's name.
     *
     * @param nameOfIngredient the ingredient's new name
     */
    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }

    /**
     * Set the ingredient's unit of measurement.
     *
     * @param unitMeasurement the new unit of measurement
     */
    public void setUnitMeasurement(String unitMeasurement) {
        this.unitMeasurement = unitMeasurement;
    }

    /**
     * Set the amount of the user-specified unit of measurement needed of this ingredient.
     *
     * @param ingredientAmount the new amount of this ingredient
     */
    public void setIngredientAmount(double ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    /**
     * Set the number of calories per user-specified unit of measurement for this ingredient.
     *
     * @param numberCaloriesPerCup the new number of calories per specified unit of ingredient
     */
    public void setNumberCaloriesPerCup(int numberCaloriesPerCup) {
        this.numberCaloriesPerCup = numberCaloriesPerCup;
    }

    /**
     * Set the total number of calories for this ingredient.
     *
     * @param totalCalories the new total number of calories for the full quantity of this ingredient
     */
    public void setTotalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     * Create a new Ingredient with default "blank" values
     */
    public Ingredient(){
        this.nameOfIngredient = "";
        this.ingredientAmount = 0;
        this.unitMeasurement = "";
        this.numberCaloriesPerCup = 0;
        this.totalCalories = 0.0;
    }

    /**
     * Create a new ingredient with specified properties.
     *
     * @param nameOfIngredient the ingredient's name
     * @param unitMeasurement ingredient's unit of measurment (e.g. cups, grams, pieces)
     * @param ingredientAmount the amount required of the ingredient
     * @param numberCaloriesPerCup the number of calories per user-defined unit of measurement
     */
    public Ingredient(String nameOfIngredient, String unitMeasurement, double ingredientAmount,
                                       int numberCaloriesPerCup){
        this.nameOfIngredient = nameOfIngredient;
        this.unitMeasurement = unitMeasurement;
        this.ingredientAmount = ingredientAmount;
        this.numberCaloriesPerCup = numberCaloriesPerCup;
        // Calculate total calories. may be improper, but it works
        this.totalCalories = this.getNumberCaloriesPerCup() * this.getIngredientAmount();
    }
}
