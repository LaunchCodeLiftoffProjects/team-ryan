package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.data.IngredientRepository;
import org.launchcode.recipeapp.data.RecipeRepository;
import org.launchcode.recipeapp.models.*;
import org.launchcode.recipeapp.models.data.ShoppinglistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("shoppinglist")
public class ShoppinglistController {

    @Autowired
    ShoppinglistRepository shoppinglistRepository;

    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping
    public String displayAllShoppinglist(Model model){
        
        model.addAttribute("title", "All Shoppinglist");
        model.addAttribute("shoppinglists", shoppinglistRepository.findAll());
        return "shoppinglist/index";
    }

    @GetMapping("add")
    public String displayCreateShoppinglistForm(Model model) {
        model.addAttribute(new Shoppinglist());
        return "shoppinglist/add";
    }

    @PostMapping("add")
    public String processCreateShoppinglistForm(@ModelAttribute @Valid Shoppinglist newShoppinglist,
                                              Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute(new Shoppinglist());
            return "shoppinglist/add";
        }
        shoppinglistRepository.save(newShoppinglist);
        return "redirect:";
    }

    @GetMapping("add2")
    public String displayAddIngredientToShoppinglistForm(Model model) {
        model.addAttribute("shoppinglists", shoppinglistRepository.findAll());
        model.addAttribute("ingredients", ingredientRepository.findAll());
        //model.addAttribute(new Shoppinglist().getIngredients());
        return "shoppinglist/add2";
    }
    @PostMapping("add2")
    public String processAddIngredientToShoppinglistForm(@RequestParam String shoppinglistId,
                                                          @RequestParam String ingredientId,Model model) {
        /*if (errors.hasErrors()) {
            model.addAttribute("title", "Add Ingredients To Shoppinglists");
            return "shoppinglist/add2";
        }*/

        Optional<Shoppinglist> result = shoppinglistRepository.findById(Integer.parseInt(shoppinglistId));
        Optional<Ingredient> result2 = ingredientRepository.findById(Integer.parseInt(ingredientId));
        if(result.isPresent() && result2.isPresent()) {
            Shoppinglist shoppinglist = result.get();
            Ingredient ingredient = result2.get();
            if (!shoppinglist.getIngredients().contains(ingredient)) {
                shoppinglist.addIngredient(ingredient);
                shoppinglistRepository.save(shoppinglist);
            }
        }
        return "redirect:";
    }

    @GetMapping("details")
    public String displayShoppinglistDetailsForm(@RequestParam Integer shoppinglistId,Model model){

        Optional<Shoppinglist> result = shoppinglistRepository.findById(shoppinglistId);
        Shoppinglist shoppinglist = result.get();
        model.addAttribute("ingredients", shoppinglist.getIngredients());
        model.addAttribute("shoppinglist", shoppinglist);
        return "shoppinglist/details";
    }
    @GetMapping("delete")
    public String displayDeleteShoppinglistForm(Model model) {
        model.addAttribute("name", "Delete Shoppinglist");
        model.addAttribute("shoppinglists", shoppinglistRepository.findAll());
        return "shoppinglist/delete";
    }

    @PostMapping("delete")
    public String processDeleteShoppinglistForm(@RequestParam(required = false) int[] shoppinglistIds) {
        if (shoppinglistIds != null) {
            for (int id : shoppinglistIds) {
                shoppinglistRepository.deleteById(id);
            }
        }
        return "redirect:";

    }
}
