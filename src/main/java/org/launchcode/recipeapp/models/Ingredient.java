package org.launchcode.recipeapp.models;

import java.util.Objects;

public class Ingredient {
    private int id;
    private static int nextId = 1;

    private String name;
    private String description;
    private String category;



    public Ingredient(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = String.valueOf(category);
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name;
    }



    public Integer getId() {
        return id;
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
