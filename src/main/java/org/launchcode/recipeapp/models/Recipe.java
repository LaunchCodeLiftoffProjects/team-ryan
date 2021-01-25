package org.launchcode.recipeapp.models;

import org.launchcode.recipeapp.AbstractEntity;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @NotBlank(message ="Name is required")
    @Size(min = 3, max =50, message = "Name must be between 3 and 50 characters")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private RecipeDetails recipeDetails;

    @ManyToOne
    @NotNull(message ="Category is required")
    private RecipeCategory recipeCategory;
//
//    @ManyToMany
//    private final List<Tag> tags = new ArrayList<>();

    public Recipe(String name, RecipeCategory recipeCategory) {
        this.name = name;
        this.recipeCategory = recipeCategory;
    }

    public Recipe() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeDetails getRecipeDetails() {
        return recipeDetails;
    }

    public void setRecipeDetails(RecipeDetails recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    public RecipeCategory getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(RecipeCategory recipeCategory) {
        this.recipeCategory = recipeCategory;
    }

//    public List<Tag> getTags() {
//        return tags;
//    }

//    public void addTag(Tag tag){
//        this.tags.add(tag);
//    }

    @Override
    public String toString() {
        return name;
    }
}
