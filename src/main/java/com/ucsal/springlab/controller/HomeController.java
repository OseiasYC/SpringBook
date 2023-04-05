package com.ucsal.springlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucsal.springlab.service.LabService;
import com.ucsal.springlab.service.ProfessorService;

@Controller
public class HomeController {

    @Autowired
    private LabService labService;

    @Autowired
    private ProfessorService professorService;

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
}
