package org.launchcode.recipeapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class RecipeCategory  extends AbstractRecipe{

    @NotBlank(message ="Name is required")
    @Size(min = 3, max =50, message = "Name must be between 3 and 50 characters")
    private String name;

    @OneToMany(mappedBy = "recipeCategory")
    private final List<Recipe> recipes = new ArrayList<>();
    public RecipeCategory(@NotBlank(message = "Name is required") @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") String name) {
        this.name = name;
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

    public RecipeCategory() {

    }

}
