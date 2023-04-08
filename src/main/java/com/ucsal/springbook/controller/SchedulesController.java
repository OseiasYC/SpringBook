package com.ucsal.springbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springbook.model.ApprovedBookings;
import com.ucsal.springbook.service.ApprovedBookingsService;

@Controller
public class SchedulesController {

    @Autowired
    ApprovedBookingsService approvedBookingsService;

    @GetMapping("/schedules")
    public ModelAndView schedules() {
        ModelAndView schedules = new ModelAndView("schedules");
        List<ApprovedBookings> bookings = approvedBookingsService.findAll();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ADMIN"));

        schedules.addObject("isAdmin", isAdmin);
        schedules.addObject("bookings", bookings);

        return schedules;
    }

    @GetMapping("deleteApproved/{id}")
    public String delete(@PathVariable("id") Long id) {
        approvedBookingsService.delete(id);
        return "redirect:/schedules";
    }

}