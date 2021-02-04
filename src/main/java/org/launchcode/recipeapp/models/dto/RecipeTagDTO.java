package org.launchcode.recipeapp.models.dto;
import org.launchcode.recipeapp.models.Recipe;
import org.launchcode.recipeapp.models.Tag;
import javax.validation.constraints.NotNull;
public class RecipeTagDTO {
    @NotNull
    private Recipe recipe;
    @NotNull
    private Tag tag;
    public RecipeTagDTO() {}
    public Recipe getRecipe() {
        return recipe;
    }
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public Tag getTag() {
        return tag;
    }
    public void setTag(Tag tag) {
        this.tag = tag;
    }
}