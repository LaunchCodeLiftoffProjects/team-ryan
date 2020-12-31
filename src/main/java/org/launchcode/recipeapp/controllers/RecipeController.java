package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.data.RecipeRepository;
import org.launchcode.recipeapp.models.Recipe;
import org.launchcode.recipeapp.models.RecipeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String displayAllRecipes(Model model){
        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes/index";
    }
    @GetMapping("create")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("types", RecipeType.values());
        return "recipes/create";
    }
    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors, Model model){
       if(errors.hasErrors()){
           model.addAttribute("title", "Create Recipe");
           return "recipes/create";
       }
        recipeRepository.save(newRecipe);
        return "redirect:/recipes";
    }
    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model){
        model.addAttribute("title", "Delete Recipe");
        model.addAttribute("recipes",recipeRepository.findAll());
        return "recipes/delete";
    }
    @PostMapping("delete")
    public String processDeleteRecipesForm(@RequestParam (required = false) int[] recipeIDs, Model model){
        if(recipeIDs!=null) {
            for (int id : recipeIDs) {
                recipeRepository.deleteById(id);
            }

        }
        return "redirect:";
    }
}
