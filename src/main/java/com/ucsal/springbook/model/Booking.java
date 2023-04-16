package com.ucsal.springbook.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Professor professor;

    @OneToOne
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "lab_id")
    private Lab lab;

    @Column(nullable = false)
    private LocalDateTime timeRequest;

    @Column(nullable = false)
    private LocalDateTime timeInit;

    @Column(nullable = false)
    private LocalDateTime timeFinal;

    @Column(nullable = false)
    private boolean approved;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public LocalDateTime getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(LocalDateTime timeRequest) {
        this.timeRequest = timeRequest;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
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

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return timeRequest + " | " + lab + " | " + timeInit + " - " + timeFinal + " | " + professor + " | " + subject;
    }
    
}