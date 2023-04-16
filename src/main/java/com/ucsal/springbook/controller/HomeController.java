package com.ucsal.springbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ucsal.springbook.service.BookingService;
import com.ucsal.springbook.service.LabService;
import com.ucsal.springbook.service.SubjectService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private LabService labService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public ModelAndView home(@AuthenticationPrincipal UserDetails user) {
        ModelAndView home = new ModelAndView("home");
        
        List<String> labs = labService.getLabs();
        List<String> subjects = subjectService.getSubjectsByLogin(user.getUsername());

        home.addObject("subjects", subjects);
        home.addObject("labs", labs);
        home.addObject("user", user);
        return home;
    }

    @PostMapping("/save")
    public String save(HttpServletRequest request, @AuthenticationPrincipal UserDetails user, RedirectAttributes attributes) {
        String login = user.getUsername();
        String lab = request.getParameter("inputLab");
        String subject = request.getParameter("inputSubject");
        String date = request.getParameter("datepicker");
        String timeInit = request.getParameter("initial-time");
        String timeFinal = request.getParameter("final-time");

        bookingService.save(login, subject, lab, date, timeInit, timeFinal);

        attributes.addFlashAttribute("message", "Submitted for verification");

        return "redirect:/";
    }
}