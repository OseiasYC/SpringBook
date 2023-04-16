package com.ucsal.springbook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ucsal.springbook.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

    @Query(value = "SELECT name FROM subject s WHERE s.professor_login = ?1 ORDER BY name ASC", nativeQuery = true)
    List<String> getSubjectsByLogin(String login);
    
    @Query(value = "SELECT * FROM subject WHERE name = ?1", nativeQuery = true)
    Optional<Subject> getSubject(String subject);
    
}
