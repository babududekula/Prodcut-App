package com.pack.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pack.entity.User;
import com.pack.service.UserDetaillServiceImpl;

@Controller
public class SignupController 
{

    @Autowired
    private UserDetaillServiceImpl userService;

    @GetMapping("/signup")
    public String signupForm(Model model) 
    {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute User user) 
    {
        userService.registerUser(user);
        return "redirect:/login";
    }
}