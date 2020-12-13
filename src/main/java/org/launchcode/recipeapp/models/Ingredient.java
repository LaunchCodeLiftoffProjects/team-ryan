package org.launchcode.recipeapp.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Ingredient {
    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Please enter an ingredient")
    @Size(min = 3, max = 50, message = "Ingredient must be between 3 and 50 characters")
    private String name;

    private String description;


    private IngredientCategory category;


    public Ingredient(String name, String description, IngredientCategory category) {
        this();
        this.name = name;
        //this.description = description;
        this.category = category;

    }

    public Ingredient() {
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
   // }

    public IngredientCategory getCategory() {
        return category;
    }

    public void setCategory(IngredientCategory category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient ingredient = (Ingredient) o;
        return id == ingredient.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
