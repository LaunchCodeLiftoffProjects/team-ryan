package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.data.RecipeCategoryRepository;
import org.launchcode.recipeapp.data.RecipeRepository;
import org.launchcode.recipeapp.data.TagRepository;
import org.launchcode.recipeapp.models.Recipe;
import org.launchcode.recipeapp.models.RecipeCategory;
import org.launchcode.recipeapp.models.Tag;
import org.launchcode.recipeapp.models.dto.RecipeTagDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public String displayRecipes(@RequestParam(required = false) Integer categoryId, Model model){
        if(categoryId == null){
            model.addAttribute("title", "All Recipes");
            model.addAttribute("recipes", recipeRepository.findAll());
        }else {
            Optional<RecipeCategory> result = recipeCategoryRepository.findById(categoryId);
            if(result.isEmpty()){
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            }else {
                RecipeCategory category = result.get();
                model.addAttribute("title", "Recipes in category: " + category.getName());
                model.addAttribute("recipes", category.getRecipes());
            }
        }
        return "recipes/index";
    }

    @GetMapping("create")
    public String displayCreateRecipeForm(Model model){
        model.addAttribute("title", "Create Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("categories", recipeCategoryRepository.findAll());
        return "recipes/create";
    }
    @PostMapping("create")
    public String processCreateRecipeForm(@ModelAttribute @Valid Recipe newRecipe, Errors errors, Model model){
       if(errors.hasErrors()){
           model.addAttribute("title", "Create Recipe");
           return "recipes/create";
       }
        recipeRepository.save(newRecipe);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteRecipeForm(Model model){
        model.addAttribute("title", "Delete Recipes");
        model.addAttribute("recipes",recipeRepository.findAll());
        return "recipes/delete";
    }
    @PostMapping("delete")
    public String processDeleteRecipesForm(@RequestParam (required = false) int[] recipeIds){
        if(recipeIds != null) {
            for (int id : recipeIds) {
               recipeRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("detail")
    public String displayRecipeDetails(@RequestParam Integer recipeId, Model model) {

        Optional<Recipe> result = recipeRepository.findById(recipeId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Recipe ID: " + recipeId);
        } else {
            Recipe recipe = result.get();
            model.addAttribute("title", recipe.getName() + " Details");
            model.addAttribute("recipe", recipe);
            model.addAttribute("tags", recipe.getTags());
        }
        return "recipes/detail";
    }

    @GetMapping("add-tag")
    public String displayAddTagForm(@RequestParam Integer recipeId, Model model){
        Optional<Recipe> result = recipeRepository.findById(recipeId);
        Recipe recipe = result.get();
        model.addAttribute("title", "Add Tag to: " + recipe.getName());
        model.addAttribute("tags", tagRepository.findAll());
        RecipeTagDTO recipeTag = new RecipeTagDTO();
        recipeTag.setRecipe(recipe);
        model.addAttribute("recipeTag", recipeTag);
        return "recipes/add-tag.html";
    }

    @PostMapping("add-tag")
    public String processAddTagForm(@ModelAttribute @Valid RecipeTagDTO recipeTag,
                                    Errors errors,
                                    Model model){

        if (!errors.hasErrors()) {
            Recipe recipe = recipeTag.getRecipe();
            Tag tag = recipeTag.getTag();
            if (!recipe.getTags().contains(tag)){
                recipe.addTag(tag);
                recipeRepository.save(recipe);
            }
            return "redirect:detail?recipeId=" + recipe.getId();
        }

        return "redirect:add-tag";
    }

}
