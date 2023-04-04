package com.ucsal.springlab.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class Booking implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    private Professor professor;

    @Column(nullable = false)
    private String subject;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Lab lab;

    @Column(nullable = false)
    private LocalDateTime dateSubmit;
    
    @Column(nullable = false)
    private LocalDateTime timeInit;
    
    @Column(nullable = false)
    private LocalDateTime timeEnd;

    @Column(nullable = false)
    private boolean approved;

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

    public LocalDateTime getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(LocalDateTime dateSubmit) {
        this.dateSubmit = dateSubmit;
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