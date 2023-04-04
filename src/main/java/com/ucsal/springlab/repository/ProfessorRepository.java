package com.ucsal.springlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}
