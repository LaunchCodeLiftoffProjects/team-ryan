package org.launchcode.recipeapp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecipeController {
    @RequestMapping(value = "hello",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name, @RequestParam String about, @RequestParam String ingr, @RequestParam String direc, @RequestParam String tips){
        return name + "\n" + about + "\n" + ingr + "\n" + direc + "\n" + tips;
    }
    @GetMapping("addrecipe")
    public String helloForm(){
    return "addrecipe";
    }
}
