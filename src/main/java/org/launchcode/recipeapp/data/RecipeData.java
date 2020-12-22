package org.launchcode.recipeapp.data;

import org.launchcode.recipeapp.models.Recipes;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RecipeData {

    private static final Map<Integer, Recipes> recipes = new HashMap<>();

    public static Collection<Recipes> getAll(){
        return recipes.values();
    }
    public static Recipes getById(int id){
        return recipes.get(id);
    }
    public static void add(Recipes recipe){
        recipes.put(recipe.getId(), recipe);
    }
    public static void remove(int id){
        recipes.remove(id);
    }
}
