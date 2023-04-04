package com.ucsal.springlab.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ucsal.springlab.model.Lab;
import com.ucsal.springlab.model.Professor;
import com.ucsal.springlab.repository.LabRepository;
import com.ucsal.springlab.repository.ProfessorRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private LabRepository labRepository;

    @Override
    public void run(String[] args) throws Exception {
        saveProfessor();
        saveLab();
    }

    private void saveLab() {
        Lab lab1 = new Lab();
        Lab lab2 = new Lab();

        lab1.setId(1);
        lab1.setLami("LAMI 1");
        lab1.setDescription("Laboratório de Micro Informática 1");
        lab1.setStatus(true);
        lab1.setDesktops(20);
        lab1.setLocation("B413");

        lab2.setId(2);
        lab2.setLami("LAMI 2");
        lab2.setDescription("Laboratório de Micro Informática 2");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B414");

        labRepository.save(lab1);
        labRepository.save(lab2);
    }

    private void saveProfessor() {
        Professor fernando = new Professor();
        List<String> subjectsFernando = new ArrayList<String>();

        subjectsFernando.add("Lógica de Programação de Algoritmos");
        subjectsFernando.add("Governança de TI");
        subjectsFernando.add("Arquitetura de Software");

        fernando.setId(01);
        fernando.setName("Fernando Cézar Reis Borges");
        fernando.setLogin("fernando");
        fernando.setSubjects(subjectsFernando);

        professorRepository.save(fernando);
    }
}