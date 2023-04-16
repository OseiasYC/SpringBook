package com.ucsal.springbook.service;

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

    public Professor getProfessorByLogin(String login){
        return professorRepository.getProfessorByLogin(login).get();
    }
}