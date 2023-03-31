package com.ucsal.springlab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springlab.models.Booking;
import com.ucsal.springlab.services.BookingService;

@Controller
public class HomeController {

    @Autowired
    private BookingService bookingService;

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
