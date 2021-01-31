package org.launchcode.recipeapp.controllers;

import org.launchcode.recipeapp.User;
import org.launchcode.recipeapp.data.RecipeRepository;
import org.launchcode.recipeapp.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Controller
@RequestMapping("users")
public class UserController {

    private AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public String displayListAllUsersForm(Model model) {

        model.addAttribute("name","All Users");
        model.addAttribute("users",userRepository.findAll());
        return "users/listAllUsers";
    }

    @GetMapping("subscribe")
    public String displaySubscribeForm(Model model){
        model.addAttribute("name","Display User's Info");
        model.addAttribute("users",userRepository.findAll());
        return "users/subscribe";
    }

    @PostMapping("subscribe")
    public String processListAllUsersForm(Model model, @NotNull HttpSession session,@RequestParam(required = false) int[] userIds){
        if (userIds != null){
            User currentUser = userRepository.findById(Integer.parseInt(session.getAttribute("user").toString())).get();
            for (int id : userIds){
                Optional<User> userFind = userRepository.findById(id);
                if (userFind.isEmpty()){
                    return "redirect:";
                } else {
                    User userUnpack = userFind.get();
                    currentUser.subscribedUsers.add(userUnpack);
                }
            }
            userRepository.save(currentUser);
            return "redirect:/users/subscribedRecipes";
        }
        return "redirect:/users/subscribedRecipes";
    }

    @GetMapping("subscribedUsers")
    public String displaySubscribedUserForm(Model model) {

        model.addAttribute("name","Subscribed Users");
        model.addAttribute("users",userRepository.findAll());
        model.addAttribute("users",recipeRepository.findAll());
        return "users/subscribedRecipes";
    }

    @GetMapping("subscribedRecipes")
    public String subscribedRecipes(Model model, @NotNull HttpSession session){
        User currentUser = userRepository.findById(Integer.parseInt(session.getAttribute("user").toString())).get();
        model.addAttribute("users",currentUser.subscribedUsers);
        return "users/subscribedRecipes";
    }

}
