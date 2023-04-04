package com.ucsal.springlab.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
<<<<<<< Updated upstream
import jakarta.persistence.Table;
=======
import jakarta.persistence.ManyToOne;
>>>>>>> Stashed changes

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

<<<<<<< Updated upstream
    @Column(name = "name_professor", nullable = false)
=======
    @ManyToOne
    @JoinColumn(nullable = false)
>>>>>>> Stashed changes
    private Professor professor;

    @Column(nullable = false)
    private String subject;

<<<<<<< Updated upstream
    @Column(name = "lami_lab", nullable = false)
    private Lab lab;

    @Column(name = "date_day", nullable = false) // TODO: resolver o tipo da data, pois está somente como String
=======
    @ManyToOne
    @JoinColumn(nullable = false)
    private Lab lab;

    @Column(nullable = false)
>>>>>>> Stashed changes
    private LocalDateTime dateDay;

    @Column(nullable = false)
    private LocalDateTime timeInit;

    @Column(nullable = false)
    private LocalDateTime timeEnd;

    @Column(nullable = false)
    private boolean approved;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public LocalDateTime getDateDay() {
        return dateDay;
    }

    public void setDateDay(LocalDateTime dateDay) {
        this.dateDay = dateDay;
    }

    public LocalDateTime getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(LocalDateTime timeInit) {
        this.timeInit = timeInit;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}