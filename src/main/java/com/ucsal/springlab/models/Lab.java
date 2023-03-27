package com.ucsal.springlab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "lab")
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "lami", nullable = false)
    private String lami;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "desktops", nullable = false)
    private int desktops;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLami() {
        return lami;
    }

    public void setLami(String lami) {
        this.lami = lami;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDesktops() {
        return desktops;
    }

    public void setDesktops(int desktops) {
        this.desktops = desktops;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
