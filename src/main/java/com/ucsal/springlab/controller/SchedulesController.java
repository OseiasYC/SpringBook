package com.ucsal.springlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springlab.model.ApprovedBookings;
import com.ucsal.springlab.service.ApprovedBookingsService;

@Controller
public class SchedulesController {

    @Autowired
    ApprovedBookingsService approvedBookingsService;

    @GetMapping("/schedules")
    public ModelAndView schedules() {
        ModelAndView schedules = new ModelAndView("schedules");
        List<ApprovedBookings> bookings = approvedBookingsService.findAll();
        schedules.addObject("bookings", bookings);
        return schedules;
    }
}
