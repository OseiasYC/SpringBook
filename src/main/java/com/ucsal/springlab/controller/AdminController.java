package com.ucsal.springlab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.service.BookingService;

@Controller
public class AdminController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/admin")
    public ModelAndView admin(@AuthenticationPrincipal UserDetails user) {
        ModelAndView admin = new ModelAndView("admin");
        List<Booking> bookings = bookingService.findAll();

        admin.addObject("bookings", bookings);
        admin.addObject("user", user);

        return admin;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("save/{id}")
    public String save(@PathVariable("id") Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        bookingService.saveApproved(booking);
        bookingService.delete(id);
        return "redirect:/admin";
    }
}
