package com.ucsal.springlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsal.springlab.model.Professor;
import com.ucsal.springlab.repository.ProfessorRepository;

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
}