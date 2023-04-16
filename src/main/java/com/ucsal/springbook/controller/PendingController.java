package com.ucsal.springbook.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ucsal.springbook.model.Booking;
import com.ucsal.springbook.service.BookingService;

@Controller
public class PendingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/pending")
    public ModelAndView pending(@AuthenticationPrincipal UserDetails user) {
        ModelAndView pending = new ModelAndView("pending");
        List<Booking> bookings = bookingService.findPending();
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

    @GetMapping("approve/{id}")
    public String approve(@PathVariable("id") Long id, RedirectAttributes attributes) {
        Optional<Booking> booking = bookingService.findById(id);

        if (bookingService.isBusy(booking)) {
            attributes.addFlashAttribute("message", "This lab is already busy, please, verify");
        } else {
            bookingService.approveBooking(booking);
        }

        return "redirect:/pending";
    }
}