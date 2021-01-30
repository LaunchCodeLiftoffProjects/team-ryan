package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

//every path starts with recipes
//@RequestMapping("recipes")
public class SearchController {
    //lives at /recipes/search
    @GetMapping("search")
    public String renderSearchIndex() {
        //renders search/index
        return "search/index";
    }

    //controller to grab ID that lives at search/recipes?id=
    //need to pass this value in from view

    @GetMapping("recipes/external")
    @ResponseBody
    public String recipesWithQueryParam(@RequestParam String id, Model model) {
        //displays text on the page
        model.addAttribute("apiRecipeId", id);
        return "Id is " + id;
    }

//    @GetMapping("search/recipes")
//    @ResponseBody
//    public String passIdToView(@RequestParam String id) {
//        //displays text on the page
//        return "search/recipes";
//    }



}




