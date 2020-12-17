package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Recipe")
public class RecipeController {
    private static List<String> recipes = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model)
    {
           model.addAttribute("recipes", recipes);
           return "Recipe/main";
    }
    @GetMapping("create")
    public String renderCreateEventForm()
    {
        return "Recipe/create";
    }
    @PostMapping("create")
    public String createRecipe(@RequestParam String name, @RequestParam String about, @RequestParam String ingr, @RequestParam String direc, @RequestParam String tips, @RequestParam String photo, @RequestParam String qserve, @RequestParam String preptime, @RequestParam String cooktime, @RequestParam String coursetype, Model model){
        recipes.add(name);
        recipes.add(about);
        recipes.add(ingr);
        recipes.add(direc);
        recipes.add(tips);
        recipes.add(photo);
        recipes.add(qserve);
        recipes.add(preptime);
        recipes.add(cooktime);
        recipes.add(coursetype);
        model.addAttribute("recipes", recipes);
        return "Recipe/display";
    }
}
