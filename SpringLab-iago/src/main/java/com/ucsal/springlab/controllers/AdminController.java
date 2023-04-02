package com.ucsal.springlab.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public ModelAndView admin(@AuthenticationPrincipal UserDetails user) {
        ModelAndView admin = new ModelAndView("admin");
        admin.addObject("user", user);
        return admin;
    }
}
