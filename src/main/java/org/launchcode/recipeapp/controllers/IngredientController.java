package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.models.Ingredient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
//templates/ingredients or ingredients?
@RequestMapping("ingredients")

public class IngredientController {

    private static List<Ingredient> ingredients = new ArrayList<>();

    @GetMapping
    public String displayAllIngredients(Model model) {
        model.addAttribute("name", "All Ingredients");
        model.addAttribute("ingredients", ingredients);
        return "ingredients/index";
    }

    @GetMapping("create")
    public String displayCreateIngredientForm(Model model) {
        model.addAttribute("name", "Create Ingredient");
        return "ingredients/create";
    }

    @PostMapping("create")
    public String processCreateIngredientForm(@RequestParam String ingredientName,
                                              @RequestParam String ingredientDescription) {
        ingredients.add(new Ingredient(ingredientName, ingredientDescription));
        return "redirect:";
    }

}
