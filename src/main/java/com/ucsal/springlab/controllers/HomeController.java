package com.ucsal.springlab.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home(@AuthenticationPrincipal UserDetails user) {
        ModelAndView page = new ModelAndView("home");
        page.addObject("user", user);
        return page;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
 // @PostMapping("/")
    // public String saveBooking(@ModelAttribute("booking") Booking booking) {
    //     bookingService.save(booking);
    //     return "redirect:/";
    // }
}
