package com.ucsal.springlab.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springlab.model.Booking;
import com.ucsal.springlab.service.BookingService;

@Controller
public class PendingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/pending")
    public ModelAndView pending(@AuthenticationPrincipal UserDetails user) {
        ModelAndView pending = new ModelAndView("pending");
        List<Booking> bookings = bookingService.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ADMIN"));

        pending.addObject("isAdmin", isAdmin);
        pending.addObject("bookings", bookings);
        pending.addObject("user", user);

        return pending;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return "redirect:/pending";
    }

    @GetMapping("save/{id}")
    public String save(@PathVariable("id") Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        bookingService.saveApproved(booking);
        bookingService.delete(id);
        return "redirect:/pending";
    }
}