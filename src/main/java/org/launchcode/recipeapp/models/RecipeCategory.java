/*
package org.launchcode.recipeapp.models;

import org.launchcode.recipeapp.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipeCategory  extends AbstractEntity {

    @Size(min = 3, max =50, message = "Name must be between 3 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "recipeCategory")
    private final List<Recipe> recipes = new ArrayList<>();
    public RecipeCategory(@Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name) {
        this.name = name;
    }
    public RecipeCategory() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    @Override
    public String toString() {
        return name;
    }

}
*/
