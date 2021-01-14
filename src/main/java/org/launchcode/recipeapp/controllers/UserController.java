package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("subscribe")
    public String displayListAllUsersForm(Model model) {

        model.addAttribute("username","List All Users");
        model.addAttribute("users",userRepository.findAll());
       return "users/listAllUsers";
    }

    @PostMapping("subscribe")
    public String processListAllUsersForm(@RequestParam(required = false) int[] userIds){
        if (userIds != null){
            for (int id : userIds){
                userRepository.findById(id);
            }
        }
        return "redirect:";
    }
}
