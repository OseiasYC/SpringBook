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
        Lab lab3 = new Lab();
        Lab lab4 = new Lab();
        Lab lab5 = new Lab();
        Lab lab6 = new Lab();
        Lab lab7 = new Lab();
        Lab lab8 = new Lab();
        Lab lab9 = new Lab();
        Lab lab10 = new Lab();
        Lab lab11 = new Lab();

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

        lab2.setId(3);
        lab2.setLami("LAMI 3");
        lab2.setDescription("Laboratório de Micro Informática 3");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B415");

        lab2.setId(4);
        lab2.setLami("LAMI 4");
        lab2.setDescription("Laboratório de Micro Informática 4");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B416");

        lab2.setId(5);
        lab2.setLami("LAMI 5");
        lab2.setDescription("Laboratório de Micro Informática 5");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B417");

        lab2.setId(6);
        lab2.setLami("LAMI 6");
        lab2.setDescription("Laboratório de Micro Informática 6");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B418");

        lab2.setId(7);
        lab2.setLami("LAMI 7");
        lab2.setDescription("Laboratório de Micro Informática 7");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B419");

        lab2.setId(8);
        lab2.setLami("LAMI 8");
        lab2.setDescription("Laboratório de Micro Informática 8");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B420");

        lab2.setId(9);
        lab2.setLami("LAMI 9");
        lab2.setDescription("Laboratório de Micro Informática 9");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B421");

        lab2.setId(10);
        lab2.setLami("LAMI 10");
        lab2.setDescription("Laboratório de Micro Informática 10");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B422");

        lab2.setId(11);
        lab2.setLami("LAMI WEX");
        lab2.setDescription("Laboratório de Micro Informática LamiWex");
        lab2.setStatus(true);
        lab2.setDesktops(30);
        lab2.setLocation("B423");

        labRepository.save(lab1);
        labRepository.save(lab2);
        labRepository.save(lab3);
        labRepository.save(lab4);
        labRepository.save(lab5);
        labRepository.save(lab6);
        labRepository.save(lab7);
        labRepository.save(lab8);
        labRepository.save(lab9);
        labRepository.save(lab10);
        labRepository.save(lab11);
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
