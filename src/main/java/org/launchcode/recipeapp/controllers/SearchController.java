package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    @GetMapping("search")
    //@ResponseBody
    public String index(){
        return "search/index";

    }

}
