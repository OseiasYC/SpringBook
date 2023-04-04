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

        lab3.setId(3);
        lab3.setLami("LAMI 3");
        lab3.setDescription("Laboratório de Micro Informática 3");
        lab3.setStatus(true);
        lab3.setDesktops(30);
        lab3.setLocation("B415");

        lab4.setId(4);
        lab4.setLami("LAMI 4");
        lab4.setDescription("Laboratório de Micro Informática 4");
        lab4.setStatus(true);
        lab4.setDesktops(30);
        lab4.setLocation("B416");

        lab5.setId(5);
        lab5.setLami("LAMI 5");
        lab5.setDescription("Laboratório de Micro Informática 5");
        lab5.setStatus(true);
        lab5.setDesktops(30);
        lab5.setLocation("B417");

        lab6.setId(6);
        lab6.setLami("LAMI 6");
        lab6.setDescription("Laboratório de Micro Informática 6");
        lab6.setStatus(true);
        lab6.setDesktops(30);
        lab6.setLocation("B418");

        lab7.setId(7);
        lab7.setLami("LAMI 7");
        lab7.setDescription("Laboratório de Micro Informática 7");
        lab7.setStatus(true);
        lab7.setDesktops(30);
        lab7.setLocation("B419");

        lab8.setId(8);
        lab8.setLami("LAMI 8");
        lab8.setDescription("Laboratório de Micro Informática 8");
        lab8.setStatus(true);
        lab8.setDesktops(30);
        lab8.setLocation("B420");

        lab9.setId(9);
        lab9.setLami("LAMI 9");
        lab9.setDescription("Laboratório de Micro Informática 9");
        lab9.setStatus(true);
        lab9.setDesktops(30);
        lab9.setLocation("B421");

        lab10.setId(10);
        lab10.setLami("LAMI 10");
        lab10.setDescription("Laboratório de Micro Informática 10");
        lab10.setStatus(true);
        lab10.setDesktops(30);
        lab10.setLocation("B422");

        lab11.setId(11);
        lab11.setLami("LAMI WEX");
        lab11.setDescription("Laboratório de Micro Informática 11");
        lab11.setStatus(true);
        lab11.setDesktops(30);
        lab11.setLocation("B423");

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
