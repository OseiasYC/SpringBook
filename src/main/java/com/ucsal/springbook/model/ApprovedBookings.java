package com.ucsal.springbook.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "approved_books")
public class ApprovedBookings implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(nullable = false)
    private String professor;

    @Column(nullable = false)
    private String subject;

    @JoinColumn(nullable = false)
    private String lab;

    @Column(nullable = false)
    private LocalDateTime timeRequest;

    @Column(nullable = false)
    private LocalDateTime timeInit;

    @Column(nullable = false)
    private LocalDateTime timeFinal;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public LocalDateTime getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(LocalDateTime timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }

    public LocalDateTime getTimeInit() {
        return timeInit;
    }

    public void setTimeInit(LocalDateTime timeInit) {
        this.timeInit = timeInit;
    }

    public LocalDateTime getTimeFinal() {
        return timeFinal;
    }

    public void setTimeFinal(LocalDateTime timeFinal) {
        this.timeFinal = timeFinal;
    }

}