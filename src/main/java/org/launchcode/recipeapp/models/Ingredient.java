package org.launchcode.recipeapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "Please enter an ingredient")
    @Size(min = 3, max = 50, message = "Ingredient must be between 3 and 50 characters")
    private String name;

    private IngredientCategory category;
    private IngredientToList toList;

    @ManyToMany
    private final List<Shoppinglist> shoppinglists = new ArrayList<>();

    public Ingredient(String name, String description, IngredientCategory category, IngredientToList toList) {
        this.name = name;
        this.category = category;
        this.toList = toList;
    }

    public Ingredient() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientCategory getCategory() {
        return category;
    }

    public void setCategory(IngredientCategory category) {
        this.category = category;
    }

    public IngredientToList getToList() {
        return toList;
    }

    public void setToList(IngredientToList toList) {
        this.toList = toList;
    }

    public Integer getId() {
        return id;
    }

    public List<Shoppinglist> getShoppinglists() {
        return shoppinglists;
    }

    public void addShoppinglist(Shoppinglist shoppinglist){
        this.shoppinglists.add(shoppinglist);
    }
    public void removeShoppinglist(Shoppinglist shoppinglist){
        this.shoppinglists.remove(shoppinglist);
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
