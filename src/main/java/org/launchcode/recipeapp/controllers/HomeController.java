
package org.launchcode.recipeapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value="", produces = "application/json")
    public String index() {

        return "{\"greeting\":\"hello world\"}";

    }
}
