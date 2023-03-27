package com.ucsal.springlab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Professor {

    @Id
    private int id;

    private String name;

    private String login;

    private String password;

    private String subject;
}