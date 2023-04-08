package com.ucsal.springbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springbook.model.Professor;
import com.ucsal.springbook.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public void save(Professor professor) {
        professorRepository.save(professor);
    }

    public List<String> getSubjects(String login) {
        return professorRepository.getSubjects(login);
    }

    public String getName(String login) {
        return professorRepository.getName(login);
    }
}