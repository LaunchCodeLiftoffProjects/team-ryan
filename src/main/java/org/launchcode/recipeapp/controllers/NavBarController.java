package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavBarController {

    @GetMapping("/nav")
    public String index() {

        return "nav";
    }
}