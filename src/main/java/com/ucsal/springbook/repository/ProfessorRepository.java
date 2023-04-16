package com.ucsal.springbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springbook.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query(value = "SELECT * FROM professor WHERE login = ?1", nativeQuery = true)
    Optional<Professor> getProfessorByLogin(String login);
}