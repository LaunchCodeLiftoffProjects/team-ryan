package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

//every path starts with recipes
//@RequestMapping("recipes")
public class SearchController {
    //lives at /recipes/search
    @GetMapping("search")
    public String renderSearchIndex(){
        //renders search/index
        return "search/index";
    }
//    lives at /recipes/search
//    handles requests of the form /search + search term
//    query param - id

//    @GetMapping("search")
//    //accepts both get and post requests, lives at recipes/search
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "search")
//    public String searchWithQueryParam(@RequestParam String id) {
//        return "Id is " + id;
//    }

    @GetMapping("recipes/search")
    public String recipesWithQueryParam(@RequestParam String id ){
        //displays text on the page
        return "search/recipes" + id;
    }

    //handles requests of the form /recipes/search
//    @GetMapping("search")
//    public String searchForm(){
//        return
//
//    }
//

//    @GetMapping("recipes/fromAPI")
//    @ResponseBody
//    public String grabAPIRecipeId(@RequestParam String id) {
//        return "ID " + id;
//    }

}
