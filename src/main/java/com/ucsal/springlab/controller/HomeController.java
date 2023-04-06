package com.ucsal.springlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springlab.service.BookingService;
import com.ucsal.springlab.service.LabService;
import com.ucsal.springlab.service.ProfessorService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private LabService labService;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/")
    public ModelAndView home(@AuthenticationPrincipal UserDetails user) {
        ModelAndView home = new ModelAndView("home");
        List<String> labs = labService.getLabs();
        List<String> subjects = professorService.getSubjects(user.getUsername());

        home.addObject("subjects", subjects);
        home.addObject("labs", labs);
        home.addObject("user", user);
        return home;
    }

    @PostMapping("/save")
    public String save(HttpServletRequest request, @AuthenticationPrincipal UserDetails user) {
        String professor = professorService.getName(user.getUsername());
        String lab = request.getParameter("inputLab");
        String subject = request.getParameter("inputSubject");
        String date = request.getParameter("datepicker");
        String timeInit = request.getParameter("initial-time");
        String timeFinal = request.getParameter("final-time");

        bookingService.save(professor, subject, lab, date, timeInit, timeFinal);

        return "redirect:/";
    }
}
