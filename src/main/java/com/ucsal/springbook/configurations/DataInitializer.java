package com.ucsal.springbook.configurations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ucsal.springbook.model.Booking;
import com.ucsal.springbook.model.Lab;
import com.ucsal.springbook.model.Professor;
import com.ucsal.springbook.model.Subject;
import com.ucsal.springbook.repository.BookingRepository;
import com.ucsal.springbook.service.LabService;
import com.ucsal.springbook.service.ProfessorService;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private LabService labService;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public void run(String... args) throws Exception {
        saveProfessor();
        saveLab();
        saveBooking();
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
        lab2.setDesktops(20);
        lab2.setLocation("B414");

        lab3.setId(3);
        lab3.setLami("LAMI 3");
        lab3.setDescription("Laboratório de Micro Informática 3");
        lab3.setStatus(true);
        lab3.setDesktops(20);
        lab3.setLocation("B415");

        lab4.setId(4);
        lab4.setLami("LAMI 4");
        lab4.setDescription("Laboratório de Micro Informática 4");
        lab4.setStatus(true);
        lab4.setDesktops(20);
        lab4.setLocation("B416");

        lab5.setId(5);
        lab5.setLami("LAMI 5");
        lab5.setDescription("Laboratório de Micro Informática 5");
        lab5.setStatus(true);
        lab5.setDesktops(20);
        lab5.setLocation("B417");

        lab6.setId(6);
        lab6.setLami("LAMI 6");
        lab6.setDescription("Laboratório de Micro Informática 6");
        lab6.setStatus(true);
        lab6.setDesktops(20);
        lab6.setLocation("B418");

        lab7.setId(7);
        lab7.setLami("LAMI 7");
        lab7.setDescription("Laboratório de Micro Informática 7");
        lab7.setStatus(true);
        lab7.setDesktops(20);
        lab7.setLocation("B419");

        lab8.setId(8);
        lab8.setLami("LAMI 8");
        lab8.setDescription("Laboratório de Micro Informática 8");
        lab8.setStatus(true);
        lab8.setDesktops(20);
        lab8.setLocation("B420");

        lab9.setId(9);
        lab9.setLami("LAMI 9");
        lab9.setDescription("Laboratório de Micro Informática 9");
        lab9.setStatus(true);
        lab9.setDesktops(20);
        lab9.setLocation("B421");

        lab10.setId(10);
        lab10.setLami("LAMI 10");
        lab10.setDescription("Laboratório de Micro Informática 10");
        lab10.setStatus(true);
        lab10.setDesktops(20);
        lab10.setLocation("B422");

        lab11.setId(11);
        lab11.setLami("LAMI WEX");
        lab11.setDescription("Laboratório de Micro Informática 11");
        lab11.setStatus(true);
        lab11.setDesktops(20);
        lab11.setLocation("B423");

        labService.save(lab1);
        labService.save(lab2);
        labService.save(lab3);
        labService.save(lab4);
        labService.save(lab5);
        labService.save(lab6);
        labService.save(lab7);
        labService.save(lab8);
        labService.save(lab9);
        labService.save(lab10);
        labService.save(lab11);
    }

    private void saveProfessor() {
        Professor fernando = new Professor();
        Professor osvaldo = new Professor();

        List<Subject> fernandoSubjects = new ArrayList<>();
        List<Subject> osvaldoSubjects = new ArrayList<>();

        Subject fernandoSubject1 = new Subject();
        Subject fernandoSubject2 = new Subject();
        Subject fernandoSubject3 = new Subject();

        Subject osvaldoSubject1 = new Subject();
        Subject osvaldoSubject2 = new Subject();
        Subject osvaldoSubject3 = new Subject();

        fernandoSubject1.setName("Governança de TI");
        fernandoSubject2.setName("Lógica de Prog. e Algoritmos");
        fernandoSubject3.setName("Arquitetura de Software");

        fernandoSubjects.add(fernandoSubject1);
        fernandoSubjects.add(fernandoSubject2);
        fernandoSubjects.add(fernandoSubject3);

        fernando.setId(1);
        fernando.setName("Fernando Cézar Reis Borges");
        fernando.setLogin("fernando");
        fernando.setSubjects(fernandoSubjects);

        osvaldoSubject1.setName("Raciocínio Lógico");
        osvaldoSubject2.setName("Compiladores");
        osvaldoSubject3.setName("Projeto Final");

        osvaldoSubjects.add(osvaldoSubject1);
        osvaldoSubjects.add(osvaldoSubject2);
        osvaldoSubjects.add(osvaldoSubject3);

        osvaldo.setId(2);
        osvaldo.setName("Osvaldo Requião Mello");
        osvaldo.setLogin("osvaldo");
        osvaldo.setSubjects(osvaldoSubjects);
        
        professorService.save(fernando);
        professorService.save(osvaldo);
    }

    private void saveBooking() {
        Booking booking1 = new Booking();

        LocalDateTime initialTime = LocalDateTime.parse("2023-10-20T09:00:00");
        LocalDateTime finalTime = LocalDateTime.parse("2023-10-20T09:30:00");

        booking1.setProfessor("Fernando Cézar Reis Borges");
        booking1.setSubject("Lógica de Prog. e Algoritmos");
        booking1.setLab("LAMI 2 (B414)");
        booking1.setTimeRequest(LocalDateTime.now());
        booking1.setTimeInit(initialTime);
        booking1.setTimeFinal(finalTime);

        bookingRepository.save(booking1);
    }
}