package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.data.IngredientRepository;
import org.launchcode.recipeapp.models.Ingredient;
import org.launchcode.recipeapp.models.IngredientCategory;
import org.launchcode.recipeapp.models.IngredientToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String displayAllIngredients(Model model) {
        model.addAttribute("name", "All Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/index";
    }


    @GetMapping("add")
    public String displayCreateIngredientForm(Model model) {
        model.addAttribute("name", "Add Ingredient");
        model.addAttribute(new Ingredient());
        model.addAttribute("categories", IngredientCategory.values());
        model.addAttribute("toLists", IngredientToList.values());
        return "ingredients/add";
    }

    @PostMapping("add")
    public String processCreateIngredientForm(@ModelAttribute @Valid Ingredient newIngredient,
                                              Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("name", "Add Ingredient");
            return "ingredients/add";
        }
        ingredientRepository.save(newIngredient);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteIngredientForm(Model model) {
        model.addAttribute("name", "Delete Ingredients");
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/delete";
    }

    @PostMapping("delete")
    public String processDeleteIngredientsForm(@RequestParam(required = false) int[] ingredientIds){
        if(ingredientIds != null) {
            for (int id: ingredientIds) {
                ingredientRepository.deleteById(id);
            }
        }

        return "redirect:";
    }

}
