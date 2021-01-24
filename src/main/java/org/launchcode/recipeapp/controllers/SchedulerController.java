package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.data.IngredientRepository;
import org.launchcode.recipeapp.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
public class SchedulerController {

//    @Autowired
//    private IngredientRepository ingredientRepository;
//
//    @GetMapping
//    public String displayAllIngredients(Model model) {
//        model.addAttribute("name", "All Ingredients");
//        model.addAttribute("ingredients", ingredientRepository.findAll());
//        return "scheduler";
//    }

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String displayRecipes(Model model) {
        model.addAttribute("name", "All Recipes");
        model.addAttribute("recipes", recipeRepository.findAll());
        return "scheduler";
    }
}
