package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.data.RecipeData;
import org.launchcode.recipeapp.models.Recipes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("Recipe")
public class RecipeController {

    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("recipes", RecipeData.getAll());
        return "Recipe/main";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm() {
        return "Recipe/create";
    }

    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute Recipes newRecipe){

        RecipeData.add(newRecipe);
        return "Recipe/display";

    }

    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model) {
        model.addAttribute("name", "Delete Events");
        model.addAttribute("recipes", RecipeData.getAll());
        return "Recipe/delete";
    }

    @PostMapping("delete")
    public String processDeleteRecipeForm(@RequestParam(required = false) int[] recipeIds) {
        if (recipeIds != null) {
            for (int id : recipeIds) {
                RecipeData.remove(id);
            }
        }
            return "Recipe/display";
        }

    }
