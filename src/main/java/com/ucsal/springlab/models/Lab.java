package com.ucsal.springlab.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< Updated upstream
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
=======
>>>>>>> Stashed changes

@Entity
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

<<<<<<< Updated upstream
    @Column(name = "lami", unique = true, nullable = false)
=======
    @Column(nullable = false)
>>>>>>> Stashed changes
    private String lami;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean status;

    @Column(nullable = false)
    private int desktops;

    @Column(nullable = false)
    private String location;

<<<<<<< Updated upstream
    @ManyToMany
    @Column(name = "professor_id", nullable = false)
    private Professor professor;

=======
>>>>>>> Stashed changes
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
