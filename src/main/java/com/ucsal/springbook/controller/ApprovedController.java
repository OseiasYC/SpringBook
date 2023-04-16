package com.ucsal.springbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springbook.model.Booking;
import com.ucsal.springbook.service.BookingService;

@Controller
public class ApprovedController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/approved")
    public ModelAndView approved() {
        ModelAndView approved = new ModelAndView("approved");
        List<Booking> bookings = bookingService.findApproved();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ADMIN"));

        approved.addObject("isAdmin", isAdmin);
        approved.addObject("bookings", bookings);

        return approved;
    }

    @GetMapping("deleteApproved/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookingService.delete(id);
        return "redirect:/approved";
    }

}