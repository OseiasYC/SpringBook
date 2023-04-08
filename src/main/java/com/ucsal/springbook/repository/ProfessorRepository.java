package com.ucsal.springbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springbook.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query(value = "SELECT name FROM subject s WHERE s.professor_login = ?1", nativeQuery = true)
    List<String> getSubjects(String login);

    @Query(value = "SELECT p.name FROM professor p WHERE p.login = ?1", nativeQuery = true)
    String getName(String login);
}