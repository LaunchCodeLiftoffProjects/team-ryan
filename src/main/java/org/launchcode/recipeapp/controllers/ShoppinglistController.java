package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.models.Shoppinglist;
import org.launchcode.recipeapp.models.data.ShoppinglistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("shoppinglist")
public class ShoppinglistController {

    @Autowired
    ShoppinglistRepository shoppinglistRepository;


    @GetMapping
    public String displayShoppingListItems(@RequestParam(required = false) Integer shoppingListId, Model model) {
        Optional<Shoppinglist> result = shoppinglistRepository.findById(shoppingListId);
        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid ShoppingList ID: " + shoppingListId);
        } else {
            Shoppinglist shoppinglist = result.get();
            model.addAttribute("title", "Recipes in shoppinglist: " + shoppinglist.getId());
            model.addAttribute("recipes", shoppinglist.getRecipes());
        }
        return "shoppinglist/index";
    }

    @PostMapping("add")
    public String addRecipeToShoppinglist(@RequestParam(required = false) Integer recipeId,Integer shoppinglistId, Model model) {


    }
}
