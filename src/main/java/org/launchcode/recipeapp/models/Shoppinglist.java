package org.launchcode.recipeapp.models;

import org.launchcode.recipeapp.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Shoppinglist {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message ="Name is required")
    @Size(min = 3, max =50, message = "Name must be between 3 and 50 characters")
    private String name;

    @ManyToMany
    private final List<Ingredient> ingredients = new ArrayList<>();


    public Shoppinglist(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
    public void removeIngredient(Ingredient ingredient){
        this.ingredients.remove(ingredient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoppinglist that = (Shoppinglist) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
