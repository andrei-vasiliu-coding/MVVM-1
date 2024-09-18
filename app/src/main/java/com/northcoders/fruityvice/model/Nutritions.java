package com.northcoders.fruityvice.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.northcoders.fruityvice.BR;

public class Nutritions extends BaseObservable {

    private int calories;
    private double fat;
    private double sugar;
    private double carbohydrates;
    private double protein;

    //All args constructor
    public Nutritions(int calories, double fat, double sugar, double carbohydrates, double protein) {
        this.calories = calories;
        this.fat = fat;
        this.sugar = sugar;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    //No args constructor
    public Nutritions() {
    }

    @Bindable
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
        notifyPropertyChanged(BR.calories);
    }

    @Bindable
    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
        notifyPropertyChanged(BR.fat);
    }

    @Bindable
    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
        notifyPropertyChanged(BR.sugar);
    }

    @Bindable
    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
        notifyPropertyChanged(BR.carbohydrates);
    }

    @Bindable
    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
        notifyPropertyChanged(BR.protein);
    }

    @Override
    public String toString() {
        return "Calories: " + calories + "\n" +
                "Fat: " + fat + "g\n" +
                "Sugar: " + sugar + "g\n" +
                "Carbohydrates: " + carbohydrates + "g\n" +
                "Protein: " + protein + "g";
    }
}
