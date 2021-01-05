package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {


    public String ListAllUsers(Model model) {

       return "listAllUsers";
    }
}
