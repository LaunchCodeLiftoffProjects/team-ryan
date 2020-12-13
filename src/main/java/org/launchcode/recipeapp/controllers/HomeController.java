package org.launchcode.recipeapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping(value="", produces = "application/json")
    public String index(Model model) {

        return "index";
//        return "{\"greeting\":\"hello world\"}";
    }
}
