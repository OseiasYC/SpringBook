package com.ucsal.springlab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springlab.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
    @Query(value = "SELECT name FROM subject s WHERE s.professor_login = ?1", nativeQuery = true)
    List<String> getSubjects(String login);
}
