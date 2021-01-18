package org.launchcode.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SchedulerController {

    @GetMapping("/schedule")
    public String index() { return "scheduler"; }
}
